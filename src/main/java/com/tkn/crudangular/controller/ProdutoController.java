package com.tkn.crudangular.controller;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.model.Produto;
import com.tkn.crudangular.service.PedidoService;
import com.tkn.crudangular.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService produtoService){
        this.service = produtoService;
    }

    @GetMapping
    public List<Produto> list (){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Optional<Produto> listById (@PathVariable long id){

        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto){
        return service.create(produto);
    }
}
