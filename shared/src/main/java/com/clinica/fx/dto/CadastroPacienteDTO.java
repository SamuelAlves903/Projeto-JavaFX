package com.clinica.fx.dto;

import com.clinica.fx.enums.Genero;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CadastroPacienteDTO(
        @NotBlank(message = "Campo Obrigatorio!")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
        String nome,
        @NotNull(message = "Informe a data de nascimento!")
        LocalDate dataNascimento,
        @NotNull(message = "Selecione um genero!")
        Genero genero,
        @CPF(message = "CPF invalido!")
        @NotBlank(message = "Campo Obrigatorio!")
        @Size(min = 11, max = 11, message = "Tamanho do CPF invalido!")
        String cpf,
        @NotBlank(message = "Campo Obrigatorio!")
        @Size(min = 11, max = 11, message = "Tamanho do Telefone invalido!")
        String telefone,
        @Email(message = "Email invalido!")
        @NotBlank(message = "Campo Obrigatorio!")
        String email,
        @NotBlank(message = "Campo Obrigatorio!")
        @Size(min = 8, max = 8)
        String cep,
        @NotBlank(message = "Campo Obrigatorio!")
        String endereco,
        @NotBlank(message = "Campo Obrigatorio!")
        String bairro,
        @NotBlank(message = "Campo Obrigatorio!")
        String numero,
        String complemento,
        @NotBlank(message = "Campo Obrigatorio!")
        String cidade,
        @NotBlank(message = "Campo Obrigatorio!")
        @Size(min = 2, max = 2)
        String uf
        ) {}
