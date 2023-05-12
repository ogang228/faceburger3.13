package com.github.ogang228.web;

import com.github.ogang228.data.BurgerRepository;
import com.github.ogang228.data.OrderRepository;
import com.github.ogang228.data.UserRepository;
import com.github.ogang228.domain.*;
import com.github.ogang228.domain.dto.BurgerReadDto;
import com.github.ogang228.service.CartService;
import com.github.ogang228.service.ShippingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final CartService cartService;
    private final ShippingInfoService shippingInfoService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BurgerRepository burgerRepository;

    // todo exclude repos

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "shippingInfo")
    public ShippingInfo shippingInfo(
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        return shippingInfoService
                .findByUsername(user.getUsername())
                .orElse(new ShippingInfo());
    }

    @ModelAttribute(name = "burgers")
    public Map<BurgerReadDto, Integer> burgers() {
        return cartService.getBurgersInCart();
    }

    @ModelAttribute(name = "total")
    public BigDecimal total() {
        return cartService.getTotal();
    }

    @ModelAttribute(name = "count")
    public Integer count() {
        return cartService.getCount();
    }

    @ModelAttribute(name = "promo")
    public PromoCode promo() {
        return cartService.getPromo();
    }

    @ModelAttribute(name = "discount")
    public BigDecimal discount() {
        return cartService.getDiscount();
    }

    @GetMapping
    public String getOrderForm() {
        return "checkout";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors orderErrors,
                               @Valid ShippingInfo shippingInfo, Errors shippingErrors,
                               @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {

        if (orderErrors.hasErrors() || shippingErrors.hasErrors()) {
            return "checkout";
        }

        Optional<User> foundUser = userRepository.findById(user.getUsername());
        if (foundUser.isPresent()) {
            User optUser = foundUser.get();
            order.setUser(optUser);
            if (optUser.getShippingInfo() == null) {
                optUser.setShippingInfo(shippingInfo);
                userRepository.save(optUser);
            }
        }
// todo hardcoded
        order.setShippingInfo(shippingInfo);
        order.setOrderItems(cartService.getBurgersInCart()
                .entrySet()
                .stream()
                .map(x -> new OrderItem(null, order, burgerRepository.findById(x.getKey().getId()).get(), x.getValue()))
                .collect(Collectors.toList())
        );
        order.setPromoCode(cartService.getPromo());
        order.setTotal(cartService.getTotal());

        orderRepository.save(order);

        cartService.clearCart();

        return "redirect:/order/my_orders";
    }

    @GetMapping("/my_orders")
    public String showOrders(Model model,
                             @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        model.addAttribute("orders", orderRepository.findAllByUserUsername(user.getUsername()));
        return "my_orders";
    }
}
