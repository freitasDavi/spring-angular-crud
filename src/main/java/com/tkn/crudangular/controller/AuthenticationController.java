package com.tkn.crudangular.controller;

import com.tkn.crudangular.exceptions.UserAlreadyExistsException;
import com.tkn.crudangular.model.dtos.AuthenticationDTO;
import com.tkn.crudangular.model.dtos.RegisterDTO;
import com.tkn.crudangular.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService _service;

    public AuthenticationController(
            AuthenticationManager authenticationManager,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this._service = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterDTO data) {
        try {
            _service.createUser(data);

            return ResponseEntity.ok().build();
        }
        catch (UserAlreadyExistsException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
