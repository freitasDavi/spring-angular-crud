package com.tkn.crudangular.service;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.model.Usuarios;
import com.tkn.crudangular.repository.IPedidoRepository;
import com.tkn.crudangular.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final IUsuarioRepository _usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository){
        _usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> getAll(){
        return _usuarioRepository.findAll();
    }

    public Usuarios create(Usuarios novoUsuario){
        return _usuarioRepository.save(novoUsuario);
    }
}
