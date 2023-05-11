package com.github.serhx4.web;

import com.github.serhx4.service.PromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/promo")
public class PromoController {

    private final PromoService promoService;
    @GetMapping
    public String showPromo(Model model) {
        model.addAttribute("promos", promoService.findAll());
        return "promo";
    }

}
