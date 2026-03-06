package com.clinica.fx.dto;

import java.math.BigDecimal;

public record ServicoListarDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String descricao
        ) {}
