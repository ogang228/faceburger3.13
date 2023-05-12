package com.github.ogang228.service;

import com.github.ogang228.domain.PromoCode;
import com.github.ogang228.domain.dto.BurgerReadDto;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addBurger(BurgerReadDto burger);

    void removeBurger(BurgerReadDto burger);

    void addPromo(PromoCode promoCode);

    PromoCode getPromo();

    Map<BurgerReadDto, Integer> getBurgersInCart();

    BigDecimal getDiscount();

    BigDecimal getTotal();

    Integer getCount();

    void clearCart();

}
