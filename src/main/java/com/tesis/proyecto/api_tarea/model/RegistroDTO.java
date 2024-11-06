package com.tesis.proyecto.api_tarea.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegistroDTO {
    // Getters y setters
    private Long alumnoId;
    private Long cursoId;
    private LocalDate fechaRegistro;
    private String estadoRegistro;

}
