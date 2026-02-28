package com.clinica.fx.model.dto;

import java.math.BigDecimal;

public record ServicoDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String especialidade
        ) {}
