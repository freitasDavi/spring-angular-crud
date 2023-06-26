package com.tkn.crudangular.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_produto", nullable = false)
    private Produto produto;

    @Column(length = 255, nullable = false)
    private LocalDate dataCompra = LocalDate.now();

    @Column(length = 255, nullable = false)
    private Double quantidade;

    @Column(length = 255, nullable = false)
    private Double valorTotal;

    @OneToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Usuarios usuarios;





}
