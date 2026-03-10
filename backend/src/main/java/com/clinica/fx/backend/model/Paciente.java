package com.clinica.fx.backend.model;

import com.clinica.fx.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private Genero genero;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Column(unique = true)
    private String telefone;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotBlank
    private String bairro;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    @NotNull
    private LocalDate dataCriacao;

    private LocalDate dataDesativacao;

    @NotNull
    private Boolean ativo;
}
