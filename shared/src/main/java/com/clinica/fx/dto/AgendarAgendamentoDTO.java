package com.clinica.fx.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendarAgendamentoDTO(
        @NotNull(message = "Selecione um paciente!")
        Long pacienteId,
        @NotNull(message = "Selecione um serviço!")
        Long servicoId,
        @NotNull(message = "Selecione um medico!")
        Long medicoId,
        @NotNull(message = "Selecione uma data!")
        @FutureOrPresent(message = "Selecione uma data de hoje ou futura!")
        LocalDate data,
        @NotNull(message = "Selecione um horario!")
        LocalTime horario
        ) {}