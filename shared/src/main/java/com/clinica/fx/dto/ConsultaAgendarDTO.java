package com.clinica.fx.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ConsultaAgendarDTO(
        Long id,
        PacienteCadastroDTO paciente,
        MedicoDTO medico,
        ServicoListarDTO servico,
        LocalDate data,
        LocalDateTime hora
        ) {}