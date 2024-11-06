package com.tesis.proyecto.api_tarea.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    private String nombreCurso;
    private String descripcion;
    private Integer duracionHoras;

    public Long getId() {
        return idCurso;
    }
}

