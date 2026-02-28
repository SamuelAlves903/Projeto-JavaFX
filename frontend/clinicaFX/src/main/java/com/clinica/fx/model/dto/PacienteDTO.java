package com.clinica.fx.model.dto;

import com.clinica.fx.model.enums.Genero;

import java.time.LocalDate;

public record PacienteDTO (
        Long id,
        String nome,
        LocalDate dataNascimento,
        Genero genero,
        String cpf,
        String telefone,
        String email,
        String cep,
        String endereco,
        String bairro,
        String numero,
        String complemento,
        String cidade,
        String estado
        ) {}
