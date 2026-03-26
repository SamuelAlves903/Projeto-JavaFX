package com.clinica.fx.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O Nome não pode ser vazio!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres!")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "Informe o Preço!")
    private BigDecimal preco;

    @Column(nullable = false)
    @NotBlank(message = "Informe a descrição do serviço")
    private String descricao;
}
