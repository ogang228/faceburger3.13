package com.github.ogang228.service;

import com.github.ogang228.domain.PromoCode;

import java.util.Optional;

public interface PromoService {

    Iterable<PromoCode> findAll();

    Optional<PromoCode> findByCode(String code);
}
