package com.tesis.proyecto.api_tarea.controller;

import com.tesis.proyecto.api_tarea.model.Curso;
import com.tesis.proyecto.api_tarea.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Implementar los métodos del controlador aquí

    @GetMapping
    public List<Curso> getCursos() {
        return cursoService.getCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        if (cursoService.getCursoById(id).isPresent()) {
            cursoService.deleteCurso(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.getCursoById(id)
                .map(cursoObj -> {
                    curso.setIdCurso(id);
                    return ResponseEntity.ok(cursoService.saveCurso(curso));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
