package com.tkn.crudangular.repository;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
