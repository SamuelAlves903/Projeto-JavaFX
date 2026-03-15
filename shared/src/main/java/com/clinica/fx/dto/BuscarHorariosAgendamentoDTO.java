package com.clinica.fx.dto;

import java.time.LocalDate;

public record BuscarHorariosAgendamentoDTO(Long idServico, Long idMedico, LocalDate data) {
}
