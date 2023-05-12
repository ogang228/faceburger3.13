package com.github.ogang228.service;

import com.github.ogang228.domain.OrderItem;

import java.util.Optional;

public interface OrderItemService {

    Optional<OrderItem> findById(Long id);

    Iterable<OrderItem> findAll();

    OrderItem save(OrderItem orderItem);

    void deleteById(Long id);

}
