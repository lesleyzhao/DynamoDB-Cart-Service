package com.lesleyzh.dynamodb_cart_service.service;

import com.lesleyzh.dynamodb_cart_service.domain.Cart;
import com.lesleyzh.dynamodb_cart_service.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    //依旧是bean injection
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(Cart cart) {
        cart.setCreatedAt(System.currentTimeMillis());
        cart.setUpdatedAt(System.currentTimeMillis());
        cartRepository.save(cart);
        return cart;
    }


}
