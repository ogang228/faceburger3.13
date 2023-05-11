package com.github.serhx4.data;

import com.github.serhx4.domain.Burger;
import com.github.serhx4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
    List<Burger> findAllByUserUsername(String username);
}
