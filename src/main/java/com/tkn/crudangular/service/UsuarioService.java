package com.tkn.crudangular.service;

import com.tkn.crudangular.dtos.CreateUserDTO;
import com.tkn.crudangular.dtos.UserLoginDTO;
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

    public Usuarios getOne(UserLoginDTO dto) {
        return _usuarioRepository.findByEmailAndSenha(dto.login(), dto.password());
    }

    public List<Usuarios> getAll(){
        return _usuarioRepository.findAll();
    }

    public Usuarios create(CreateUserDTO novoUsuario){

        Usuarios user = new Usuarios(novoUsuario.nome(), novoUsuario.email(), novoUsuario.senha(),
                novoUsuario.cidade(), novoUsuario.rua(), novoUsuario.bairro(), novoUsuario.cep(),
                novoUsuario.cpf());

        return _usuarioRepository.save(user);
    }
}
