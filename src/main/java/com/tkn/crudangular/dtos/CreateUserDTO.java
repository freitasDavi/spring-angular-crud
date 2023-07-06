package com.tkn.crudangular.dtos;

public record CreateUserDTO(
        String nome, String email, String senha,
        String cidade, String rua, String bairro,
        String cep, String cpf
) {
}
