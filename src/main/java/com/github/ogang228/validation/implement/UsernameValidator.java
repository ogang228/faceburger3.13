package com.github.ogang228.validation.implement;

import com.github.ogang228.data.UserRepository;
import com.github.ogang228.validation.UniqueUsername;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return ! userRepository.findById(username).isPresent();
    }
}
