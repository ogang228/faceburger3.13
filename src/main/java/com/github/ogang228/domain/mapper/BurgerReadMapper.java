package com.github.ogang228.domain.mapper;

import com.github.ogang228.domain.Burger;
import com.github.ogang228.domain.Ingredient;
import com.github.ogang228.domain.dto.BurgerReadDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BurgerReadMapper implements Mapper<Burger, BurgerReadDto> {

    @Override
    public BurgerReadDto map(Burger object) {
        return new BurgerReadDto(
                object.getId(),
                object.getName(),
                object.getImageUri(),
                object.getUser().getUsername(),
                object.getIngredients(),
                object.getPrice(),
                getDescription(object.getIngredients())
        );
    }

    private String getDescription(List<Ingredient> ingredients) {
        return ingredients
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.joining(", "));
    }
}
