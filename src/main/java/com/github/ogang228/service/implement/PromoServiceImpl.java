package com.github.ogang228.service.implement;

import com.github.ogang228.data.PromoCodeRepository;
import com.github.ogang228.domain.PromoCode;
import com.github.ogang228.service.PromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService {

    private final PromoCodeRepository promoCodeRepository;

    @Override
    public Iterable<PromoCode> findAll() {
        return promoCodeRepository.findAll();
    }

    @Override
    public Optional<PromoCode> findByCode(String code) {
        return promoCodeRepository.findByCode(code);
    }
}
