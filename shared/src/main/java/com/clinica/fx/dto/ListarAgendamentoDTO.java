package com.clinica.fx.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ListarAgendamentoDTO(Long id, String nomePaciente, String nomeServico, String nomeMedico, LocalDate data, LocalTime hora) {
}
