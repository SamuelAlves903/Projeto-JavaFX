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

    @NotNull(message = "Selecione um paciente!")
    @ManyToOne
    private Paciente paciente;

    @NotNull(message = "Selecione um serviço!")
    @ManyToOne
    private Servico servico;

    @NotNull(message = "Selecione um medico!")
    @ManyToOne
    private Medico medico;

    @NotNull(message = "Selecione uma data!")
    private LocalDate data;

    @NotNull(message = "Selecione um horario!")
    private LocalTime horario;
}
