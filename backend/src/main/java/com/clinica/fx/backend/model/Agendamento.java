package com.clinica.fx.backend.model;

import jakarta.persistence.*;
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

    @NotNull(message = "O Paciente não pode ser nulo!")
    @ManyToOne
    private Paciente paciente;

    @NotNull(message = "O Servico não pode ser nulo!")
    @ManyToOne
    private Servico servico;

    @NotNull(message = "O Medico não pode ser nulo!")
    @ManyToOne
    private Medico medico;

    @NotNull(message = "A Data não pode ser nula!")
    private LocalDate data;

    @NotNull(message = "O Horario não pode ser nulo!")
    private LocalTime horario;
}
