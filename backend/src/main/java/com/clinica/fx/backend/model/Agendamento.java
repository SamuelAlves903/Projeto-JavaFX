package com.clinica.fx.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Paciente paciente;

    @NotNull
    @ManyToOne
    private Servico servico;

    @NotNull
    @ManyToOne
    private Medico medico;

    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime hora;
}
