package com.github.ogang228.domain.mapper;

import com.github.ogang228.data.UserRepository;
import com.github.ogang228.domain.Burger;
import com.github.ogang228.domain.User;
import com.github.ogang228.domain.dto.BurgerCreateDto;
import com.github.ogang228.exception.NoUserFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BurgerCreateMapper implements Mapper<BurgerCreateDto, Burger> {

    private final UserRepository userRepository;

    @Override
    public Burger map(BurgerCreateDto object) {
        return Burger.builder()
                .name(object.getName())
                .imageUri(object.getImageUri())
                .user(getUser(object.getUsername()))
                .ingredients(object.getIngredients())
                .build();
    }

    private User getUser(String username) {
        return userRepository.findById(username)
                .orElseThrow(() -> new NoUserFoundException(username));
    }
}
