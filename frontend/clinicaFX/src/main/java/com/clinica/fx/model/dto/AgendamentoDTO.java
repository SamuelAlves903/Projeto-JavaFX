package com.clinica.fx.model.dto;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        Long id,
        Long pacienteId,
        Long medicoId,
        Long servicoId,
        LocalDateTime dataHora
        ) {}