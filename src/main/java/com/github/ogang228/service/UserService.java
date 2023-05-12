package com.github.ogang228.service;

import com.github.ogang228.domain.User;
import com.github.ogang228.security.RegistrationForm;

import java.util.Optional;

public interface UserService {

    Optional<User> save(RegistrationForm form);

}
