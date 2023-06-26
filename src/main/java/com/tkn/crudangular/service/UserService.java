package com.tkn.crudangular.service;

import com.tkn.crudangular.exceptions.UserAlreadyExistsException;
import com.tkn.crudangular.model.User;
import com.tkn.crudangular.model.dtos.RegisterDTO;
import com.tkn.crudangular.repository.IUsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUsersRepository _repository;

    public UserService (IUsersRepository repository) {
        _repository = repository;
    }

    public void createUser (RegisterDTO dto) throws UserAlreadyExistsException {
        if (this._repository.findByLogin(dto.login()) != null) throw new UserAlreadyExistsException();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User newUser = new User(dto.login(), encryptedPassword, dto.role());

        _repository.save(newUser);
    }
}
