package com.tkn.crudangular.repository;

import com.tkn.crudangular.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsersRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}
