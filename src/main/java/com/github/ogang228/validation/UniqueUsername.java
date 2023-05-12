package com.github.ogang228.validation;


import com.github.ogang228.validation.implement.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(
        validatedBy = UsernameValidator.class
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

    String message() default "Username is already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
