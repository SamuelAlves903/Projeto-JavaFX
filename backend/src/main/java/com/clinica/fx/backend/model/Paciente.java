package com.clinica.fx.backend.model;

import com.clinica.fx.enums.Genero;
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
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O Nome não pode ser vazio!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Genero genero;

    @Column(unique = true, length = 11,  nullable = false)
    @CPF(message = "CPF invalido!")
    @NotBlank(message = "O CPF não pode ser vazio!")
    @Size(min = 11, max = 11, message = "Tamanho do CPF invalido!")
    private String cpf;

    @Column(unique = true,  length = 11,  nullable = false)
    @NotBlank(message = "O Telefone não pode ser vazio!")
    @Size(min = 11, max = 11, message = "Tamanho do Telefone invalido!")
    private String telefone;

    @Column(unique = true, nullable = false)
    @Email(message = "Email invalido!")
    @NotBlank(message = "O Email não pode ser vazio!")
    private String email;

    @Column(nullable = false, length = 8)
    @NotBlank(message = "O Cep não pode ser vazio!")
    @Size(min = 8, max = 8)
    private String cep;

    @Column(nullable = false)
    @NotBlank(message = "O Endereço não pode ser vazio!")
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "O Bairro não pode ser vazio!")
    private String bairro;

    @Column(nullable = false)
    @NotBlank(message = "O Numero não pode ser vazio!")
    private String numero;

    private String complemento;

    @Column(nullable = false)
    @NotBlank(message = "A Cidade não pode ser vazio!")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "O UF não pode ser vazio!")
    @Size(min = 2, max = 2)
    private String uf;

    @Column(nullable = false)
    @NotNull(message = "Informe a data criação")
    private LocalDate dataCriacao;

    private LocalDate dataDesativacao;

    @Column(nullable = false)
    @NotNull(message = "Ativo não pode ser nulo!")
    private Boolean ativo;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
        if (this.ativo == null) {
            this.ativo = true;
        }
    }
}
