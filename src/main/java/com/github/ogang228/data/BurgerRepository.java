package com.github.ogang228.data;

import com.github.ogang228.domain.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
    List<Burger> findAllByUserUsername(String username);
}
