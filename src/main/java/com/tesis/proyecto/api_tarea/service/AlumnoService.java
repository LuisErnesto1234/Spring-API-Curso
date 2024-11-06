package com.tesis.proyecto.api_tarea.service;

import com.tesis.proyecto.api_tarea.model.Alumno;
import com.tesis.proyecto.api_tarea.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public String deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
        return "Alumno eliminado correctamente";
    }

}
