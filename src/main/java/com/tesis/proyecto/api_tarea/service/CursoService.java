package com.tesis.proyecto.api_tarea.service;

import com.tesis.proyecto.api_tarea.model.Curso;
import com.tesis.proyecto.api_tarea.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public String deleteCurso(Long id) {
        cursoRepository.deleteById(id);
        return "Curso eliminado correctamente";
    }
}
