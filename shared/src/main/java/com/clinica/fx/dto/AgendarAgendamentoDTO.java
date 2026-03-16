package com.clinica.fx.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendarAgendamentoDTO(
        Long id,
        Long pacienteId,
        Long servicoId,
        Long medicoId,
        LocalDate data,
        LocalTime hora
        ) {}