package com.github.ogang228.service;

import com.github.ogang228.domain.dto.BurgerCreateDto;
import com.github.ogang228.domain.dto.BurgerReadDto;

import java.util.List;
import java.util.Optional;

public interface BurgerService {

    Optional<BurgerReadDto> findById(Long id);

    List<BurgerReadDto> findAllById(Iterable<Long> ids);

    List<BurgerReadDto> findAllByUsername(String username);

    BurgerReadDto save(BurgerCreateDto burgerDto);

    boolean deleteById(Long id);
}
