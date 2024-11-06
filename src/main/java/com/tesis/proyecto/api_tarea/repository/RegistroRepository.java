package com.tesis.proyecto.api_tarea.repository;

import com.tesis.proyecto.api_tarea.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {}
