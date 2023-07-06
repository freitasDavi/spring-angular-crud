package com.tkn.crudangular.controller;

import com.tkn.crudangular.dtos.CreateUserDTO;
import com.tkn.crudangular.dtos.UserLoginDTO;
import com.tkn.crudangular.model.Produto;
import com.tkn.crudangular.model.Usuarios;
import com.tkn.crudangular.service.ProdutoService;
import com.tkn.crudangular.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService usuarioService){
        this.service = usuarioService;
    }

    @GetMapping
    public List<Usuarios> list (){
        return service.getAll();
    }

    @PostMapping("login")
    public Usuarios getUser (@RequestBody UserLoginDTO dto) {
        return service.getOne(dto);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuarios create(@RequestBody CreateUserDTO usuarios){

        return service.create(usuarios);
    }
}
