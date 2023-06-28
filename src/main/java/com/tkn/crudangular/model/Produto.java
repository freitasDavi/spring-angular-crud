package com.tkn.crudangular.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String categoria;

    @Column(length = 255, nullable = false)
    private Double preco;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String img;

}
