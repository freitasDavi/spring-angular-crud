package com.tkn.crudangular.controller;

import com.tkn.crudangular.exceptions.UserAlreadyExistsException;
import com.tkn.crudangular.model.User;
import com.tkn.crudangular.model.dtos.AuthenticationDTO;
import com.tkn.crudangular.model.dtos.LoginResponse;
import com.tkn.crudangular.model.dtos.RegisterDTO;
import com.tkn.crudangular.service.TokenService;
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
    private final TokenService _tokenService;

    public AuthenticationController(
            AuthenticationManager authenticationManager,
            UserService userService,
            TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this._service = userService;
        this._tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = _tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
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
