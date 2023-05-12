package com.github.ogang228.service.implement;

import com.github.ogang228.data.ShippingInfoRepository;
import com.github.ogang228.domain.ShippingInfo;
import com.github.ogang228.service.ShippingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShippingInfoServiceImpl implements ShippingInfoService {

    private final ShippingInfoRepository shippingInfoRepository;

    @Override
    public Optional<ShippingInfo> findById(Long id) {
        return shippingInfoRepository.findById(id);
    }

    @Override
    public Optional<ShippingInfo> findByUsername(String username) {
        return shippingInfoRepository.findByUserUsername(username);
    }

    @Override
    public ShippingInfo saveAndFlush(ShippingInfo shippingInfo) {
       return shippingInfoRepository.save(shippingInfo);
    }

    @Override
    public void deleteById(Long id) {
        shippingInfoRepository.deleteById(id);
    }
}
