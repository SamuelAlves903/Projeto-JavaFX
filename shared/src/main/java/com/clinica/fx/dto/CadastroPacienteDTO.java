package com.clinica.fx.dto;

import com.clinica.fx.enums.Genero;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CadastroPacienteDTO(
        @NotBlank(message = "O Nome não pode ser vazio!")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
        String nome,
        @NotNull(message = "Data de nascimento deve ser informada!")
        LocalDate dataNascimento,
        @NotNull
        Genero genero,
        @CPF(message = "CPF invalido!")
        @NotBlank(message = "O CPF não pode ser vazio!")
        @Size(min = 11, max = 11, message = "Tamanho do CPF invalido!")
        String cpf,
        @NotBlank(message = "O Telefone não pode ser vazio!")
        @Size(min = 11, max = 11, message = "Tamanho do Telefone invalido!")
        String telefone,
        @Email(message = "Email invalido!")
        @NotBlank(message = "O Email não pode ser vazio!")
        String email,
        @NotBlank(message = "O Cep não pode ser vazio!")
        @Size(min = 8, max = 8)
        String cep,
        @NotBlank(message = "O Endereço não pode ser vazio!")
        String endereco,
        @NotBlank(message = "O Bairro não pode ser vazio!")
        String bairro,
        @NotBlank(message = "O Numero não pode ser vazio!")
        String numero,
        String complemento,
        @NotBlank(message = "A Cidade não pode ser vazio!")
        String cidade,
        @NotBlank(message = "O UF não pode ser vazio!")
        @Size(min = 2, max = 2)
        String uf
        ) {}
