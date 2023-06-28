package com.tkn.crudangular.service;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.repository.IPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final IPedidoRepository _pedidoRepository;

    public PedidoService(IPedidoRepository pedidoRepository){
        _pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAll(){
        return _pedidoRepository.findAll();
    }

    public Pedido create(Pedido novoPedido){
        return _pedidoRepository.save(novoPedido);
    }
}
