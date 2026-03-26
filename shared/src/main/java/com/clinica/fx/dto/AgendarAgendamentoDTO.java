package com.clinica.fx.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendarAgendamentoDTO(
        @NotNull(message = "O Paciente não pode ser nulo!")
        Long pacienteId,
        @NotNull(message = "O Servico não pode ser nulo!")
        Long servicoId,
        @NotNull(message = "O Medico não pode ser nulo!")
        Long medicoId,
        @NotNull(message = "A Data não pode ser nula!")
        @FutureOrPresent(message = "A data dever ser hoje ou futura!")
        LocalDate data,
        @NotNull(message = "O Horario não pode ser nulo!")
        LocalTime hora
        ) {}