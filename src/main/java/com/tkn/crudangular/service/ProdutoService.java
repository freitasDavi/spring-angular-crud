package com.tkn.crudangular.service;

import com.tkn.crudangular.model.Pedido;
import com.tkn.crudangular.model.Produto;
import com.tkn.crudangular.repository.IPedidoRepository;
import com.tkn.crudangular.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final IProdutoRepository _produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository){
        _produtoRepository = produtoRepository;
    }

    public List<Produto> getAll(){
        return _produtoRepository.findAll();
    }

    public Produto create(Produto novoProduto){
        return _produtoRepository.save(novoProduto);
    }
}
