package com.clinica.fx.dto;

import java.math.BigDecimal;

public record ServicoDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String descricao
        ) {}
