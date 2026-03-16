package com.clinica.fx.dto;

import com.clinica.fx.enums.Genero;

public record ListarPacienteDTO(

        Long id,
        String nome,
        Genero genero,
        String cpf,
        String telefone,
        String email,
        String cep,
        String cidade,
        String uf
) {}
