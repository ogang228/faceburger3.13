package com.github.ogang228.validation.implement;

import com.github.ogang228.data.UserRepository;
import com.github.ogang228.validation.UniqueEmail;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return ! userRepository.findByEmail(email).isPresent();
    }
}
