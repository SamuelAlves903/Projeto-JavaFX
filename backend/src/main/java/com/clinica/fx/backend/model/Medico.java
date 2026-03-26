package com.clinica.fx.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O Nome não pode ser vazio!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
    private String nome;

    @Column(unique = true, length = 11,  nullable = false)
    @CPF(message = "CPF invalido!")
    @NotBlank(message = "O CPF não pode ser vazio!")
    @Size(min = 11, max = 11, message = "Tamanho do CPF invalido!")
    private String cpf;

    @Column(unique = true, nullable = false)
    @Email(message = "Email invalido!")
    @NotBlank(message = "O Email não pode ser vazio!")
    private String email;

    @Column(unique = true,  length = 11,  nullable = false)
    @NotBlank(message = "O Telefone não pode ser vazio!")
    @Size(min = 11, max = 11, message = "Tamanho do Telefone invalido!")
    private String telefone;

    @Column(nullable = false)
    @NotBlank(message = "O CRM não pode ser vazio!")
    private String crm;

    @Column(nullable = false)
    @NotBlank(message = "O UF-CRM não pode ser vazio!")
    private String ufCrm;

    @Column(nullable = false)
    @NotBlank(message = "O Especialidade não pode ser vazio!")
    private String especialidade;

    @Column(nullable = false)
    @NotNull(message = "a Data de Inicio de Contratação não pode ser vazio!")
    private LocalDate inicioContratacao;

    private LocalDate fimContratacao;

    @Column(nullable = false)
    @NotNull(message = "Ativo não pode ser nulo!")
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Servico servico;
}
