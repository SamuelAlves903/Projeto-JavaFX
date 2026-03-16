package com.clinica.fx.dto;

import java.math.BigDecimal;

public record ListarServicoDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String descricao
        ) {}
