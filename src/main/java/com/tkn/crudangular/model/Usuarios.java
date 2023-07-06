package com.tkn.crudangular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 255, nullable = false)
    private String email;

    @JsonIgnore
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

    public Usuarios(String nome, String email, String senha, String cidade, String rua, String bairro, String cep, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cpf = cpf;
    }
}
