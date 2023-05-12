package com.github.ogang228.domain.dto;

import com.github.ogang228.domain.Ingredient;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class IngredientDto {

    String id;
    String name;
    BigDecimal price;
    String imageUri;
    Ingredient.Type type;
}
