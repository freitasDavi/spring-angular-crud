package com.tkn.crudangular.repository;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {

    public Usuarios findByEmailAndSenha(String email, String senha);
}
