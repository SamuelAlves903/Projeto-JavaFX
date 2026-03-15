package com.clinica.fx.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ConsultaAgendarDTO(
        Long id,
        Long pacienteId,
        Long servicoId,
        Long medicoId,
        LocalDate data,
        LocalTime hora
        ) {}