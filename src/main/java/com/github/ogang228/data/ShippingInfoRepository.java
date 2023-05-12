package com.github.ogang228.data;

import com.github.ogang228.domain.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
    @Query("select s from ShippingInfo s join User u on s = u.shippingInfo where u.username = ?1")
    Optional<ShippingInfo> findByUserUsername(String username);
}
