package com.clinica.fx.backend.model;

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
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true)
    private String telefone;

    @NotBlank
    @Column(unique = true)
    private String crm;

    @NotBlank
    private String ufCrm;

    @NotBlank
    private String especialidade;

    @NotNull
    private LocalDate inicioContratacao;

    private LocalDate fimContratacao;


    @NotNull
    private Boolean ativo;


    @ManyToOne
    private Servico servico;
}
