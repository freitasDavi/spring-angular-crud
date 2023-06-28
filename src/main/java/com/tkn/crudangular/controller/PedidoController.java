package com.tkn.crudangular.controller;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final  PedidoService service;

    public PedidoController(PedidoService pedidoService){
        this.service = pedidoService;
    }

    @GetMapping
    public List<Pedido> list (){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pedido create(@RequestBody Pedido pedido){
        return service.create(pedido);
    }
}
