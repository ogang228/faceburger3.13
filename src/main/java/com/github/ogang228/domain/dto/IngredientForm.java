package com.github.ogang228.domain.dto;

import com.github.ogang228.domain.Ingredient;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class IngredientForm {

    @NotBlank
    String id;
    @NotBlank
    String name;
    BigDecimal price;
    String imageUri;
    Ingredient.Type type;

}
