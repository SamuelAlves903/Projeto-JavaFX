package com.clinica.fx.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    private Medico medico;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    private Servico servico;

    @NotBlank
    private LocalDate data;


    @NotBlank
    private LocalTime hora;
}
