package com.clinica.fx.model.dto;

import java.time.LocalDate;

public record MedicoDTO(Long id,
                        String nome,
                        String email,
                        String telefone,
                        String crm,
                        String ufCrm,
                        String especialidade,
                        LocalDate dataContratacao,
                        LocalDate dataFimContratacao,
                        Boolean ativo
                        ) {}
