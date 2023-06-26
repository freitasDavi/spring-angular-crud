package com.tkn.crudangular.service;

import com.tkn.crudangular.repository.IUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final IUsersRepository _usersRepository;

    AuthorizationService(IUsersRepository usersRepository) {
        _usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return _usersRepository.findByLogin(username);
    }
}
