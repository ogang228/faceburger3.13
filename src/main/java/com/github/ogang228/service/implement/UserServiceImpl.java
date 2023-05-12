package com.github.ogang228.service.implement;

import com.github.ogang228.data.UserRepository;
import com.github.ogang228.domain.User;
import com.github.ogang228.security.RegistrationForm;
import com.github.ogang228.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> save(RegistrationForm form) {
        return Optional.of(form)
                .map(it -> it.toUser(passwordEncoder))
                .map(userRepository::save);
    }
}
