package com.tkn.crudangular.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String senha;
// sssss
    @Column(length = 255, nullable = false)
    private String cidade;

    @Column(length = 255, nullable = true)
    private String rua;

    @Column(length = 255, nullable = true)
    private String bairro;

    @Column(length = 255, nullable = true)
    private String cep;

    @Column(length = 255, nullable = true)
    private String cpf;
}
