package com.clinica.fx.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendamentoDTO(
        Long id,
        PacienteDTO paciente,
        MedicoDTO medico,
        ServicoDTO servico,
        LocalDate data,
        LocalDateTime hora
        ) {}