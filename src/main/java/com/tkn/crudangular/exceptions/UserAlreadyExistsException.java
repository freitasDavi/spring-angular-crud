package com.tkn.crudangular.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("User already exists");
    }
}
