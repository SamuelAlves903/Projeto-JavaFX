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
    @NotBlank(message = "Campo Obrigatorio!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
    private String nome;

    @NotNull(message = "Informe a data de nascimento!")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Selecione um genero!")
    private Genero genero;

    @Column(unique = true, length = 11,  nullable = false)
    @CPF(message = "CPF invalido!")
    @NotBlank(message = "Campo Obrigatorio!")
    @Size(min = 11, max = 11, message = "Tamanho do CPF invalido!")
    private String cpf;

    @Column(unique = true,  length = 11,  nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    @Size(min = 11, max = 11, message = "Tamanho do Telefone invalido!")
    private String telefone;

    @Column(unique = true, nullable = false)
    @Email(message = "Email invalido!")
    @NotBlank(message = "Campo Obrigatorio!")
    private String email;

    @Column(nullable = false, length = 8)
    @NotBlank(message = "Campo Obrigatorio!")
    @Size(min = 8, max = 8)
    private String cep;

    @Column(nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    private String bairro;

    @Column(nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    private String numero;

    private String complemento;

    @Column(nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "Campo Obrigatorio!")
    @Size(min = 2, max = 2)
    private String uf;

    @Column(nullable = false)
    @NotNull
    private LocalDate dataCriacao;

    private LocalDate dataDesativacao;

    @Column(nullable = false)
    @NotNull
    private Boolean ativo;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
        if (this.ativo == null) {
            this.ativo = true;
        }
    }
}
