package com.tesis.proyecto.api_tarea.repository;

import com.tesis.proyecto.api_tarea.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
