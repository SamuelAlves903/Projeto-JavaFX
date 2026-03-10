package com.clinica.fx.dto;

import com.clinica.fx.enums.Genero;

import java.time.LocalDate;

public record PacienteCadastroDTO(
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
        String uf
        ) {}
