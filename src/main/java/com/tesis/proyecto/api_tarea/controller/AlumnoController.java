package com.tesis.proyecto.api_tarea.controller;

import com.tesis.proyecto.api_tarea.model.Alumno;
import com.tesis.proyecto.api_tarea.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnoService.getAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }

    @Value("${upload.path:/uploads/navidad}")  // Ruta configurada para guardar las imágenes
    private String uploadPath;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumnoProfile(@PathVariable Long id,
                                                      @RequestParam("image") MultipartFile imageFile) {
        // Verificar si el alumno existe
        Optional<Alumno> alumnoOpt = alumnoService.getAlumnoById(id);
        if (alumnoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumno = alumnoOpt.get();

        // Guardar la imagen en la carpeta especificada
        try {
            // Crear el directorio si no existe
            Path directoryPath = Paths.get(uploadPath);
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            // Generar el nombre de archivo único y guardar la imagen
            String filename = "alumno_" + id + "_" + System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filePath = directoryPath.resolve(filename);
            imageFile.transferTo(filePath);

            // Guardar la ruta en el perfil del alumno
            alumno.setPerfilUrl("/uploads/navidad/" + filename);
            alumnoService.saveAlumno(alumno);

            return ResponseEntity.ok(alumno);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();  // Error interno del servidor
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        if (alumnoService.getAlumnoById(id).isPresent()) {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
