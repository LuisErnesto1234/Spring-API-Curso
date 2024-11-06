package com.tesis.proyecto.api_tarea.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "registro")
@Getter
@Setter
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "estado_registro", length = 50)
    private String estadoRegistro = "activo";

    // Si usas getAlumnoId() en algún lugar, podría generar problemas ya que alumno aún no está asignado
    // En su lugar, accede directamente a alumno.getId() si es necesario
}