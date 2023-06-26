package com.tkn.crudangular.model.dtos;

import com.tkn.crudangular.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
