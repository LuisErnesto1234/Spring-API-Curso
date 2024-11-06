package com.tesis.proyecto.api_tarea.controller;

import com.tesis.proyecto.api_tarea.config.ErrorResponse;
import com.tesis.proyecto.api_tarea.model.Alumno;
import com.tesis.proyecto.api_tarea.model.Curso;
import com.tesis.proyecto.api_tarea.model.Registro;
import com.tesis.proyecto.api_tarea.service.AlumnoService;
import com.tesis.proyecto.api_tarea.service.CursoService;
import com.tesis.proyecto.api_tarea.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlumnoService alumnoService;

    // Obtener todos los registros
    @GetMapping
    public List<Registro> getAllRegistros() {
        return registroService.getAllRegistros();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable Long id) {
        Optional<Registro> registro = registroService.getRegistroById(id);
        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createRegistro(@RequestBody Registro registro) {
        // Verificamos que los IDs no sean nulos
        if (registro.getAlumno() == null || registro.getCurso() == null) {
            return ResponseEntity.badRequest().body("Alumno y curso son requeridos");
        }

        // Intentamos obtener los objetos Alumno y Curso desde sus servicios utilizando los IDs enviados en el JSON
        Optional<Alumno> alumnoOpt = alumnoService.getAlumnoById(registro.getAlumno().getId());
        Optional<Curso> cursoOpt = cursoService.getCursoById(registro.getCurso().getId());

        // Si no encontramos el Alumno o el Curso, devolvemos un error
        if (alumnoOpt.isEmpty() || cursoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Alumno o curso no encontrados");
        }

        // Asignamos los objetos encontrados al Registro
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setAlumno(alumnoOpt.get()); // Asignamos el Alumno
        nuevoRegistro.setCurso(cursoOpt.get());   // Asignamos el Curso
        nuevoRegistro.setFechaRegistro(registro.getFechaRegistro()); // Asignamos la fecha de registro
        nuevoRegistro.setEstadoRegistro(registro.getEstadoRegistro()); // Asignamos el estado de registro

        // Guardamos el nuevo Registro
        Registro savedRegistro = registroService.saveRegistro(nuevoRegistro);

        // Devolvemos la respuesta con el registro guardado
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistro);
    }


    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<Registro> updateRegistro(@PathVariable Long id, @RequestBody Registro registroDetails) {
        return registroService.getRegistroById(id).map(registro -> {
            registro.setAlumno(registroDetails.getAlumno());
            registro.setCurso(registroDetails.getCurso());
            registro.setFechaRegistro(registroDetails.getFechaRegistro());
            registro.setEstadoRegistro(registroDetails.getEstadoRegistro());
            Registro registroActualizado = registroService.saveRegistro(registro);
            return ResponseEntity.ok(registroActualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        if (registroService.deleteRegistroById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
