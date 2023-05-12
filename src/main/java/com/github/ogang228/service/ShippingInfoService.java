package com.github.ogang228.service;

import com.github.ogang228.domain.ShippingInfo;

import java.util.Optional;

public interface ShippingInfoService {

    Optional<ShippingInfo> findById(Long id);

    Optional<ShippingInfo> findByUsername(String username);

    ShippingInfo saveAndFlush(ShippingInfo shippingInfo);

    void deleteById(Long id);
}
