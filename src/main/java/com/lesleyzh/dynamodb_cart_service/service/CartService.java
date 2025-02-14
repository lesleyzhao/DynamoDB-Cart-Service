package com.lesleyzh.dynamodb_cart_service.service;

import com.lesleyzh.dynamodb_cart_service.domain.Cart;
import com.lesleyzh.dynamodb_cart_service.domain.CartItem;
import com.lesleyzh.dynamodb_cart_service.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    //依旧是bean injection
    //service layer就是和repository进行互动
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(String userId) {
        Cart cart = new Cart();
        cart.setCartId(UUID.randomUUID().toString());
        cart.setUserId(userId);
        cart.setCartItems(new ArrayList<>());
        cart.setCreatedAt(System.currentTimeMillis());
        cart.setUpdatedAt(System.currentTimeMillis());
        cartRepository.save(cart);
        return cart;
    }

    public Cart addItem(String cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId);
        //看一下这个item在cart里有没有，有的话就更新数量，没有就加进去
        Optional<CartItem> existingItem = cart.getCartItems().stream().filter(i -> i.getProductId().equals(item.getProductId())).findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + item.getQuantity());
        } else {
            cart.getCartItems().add(item);
        }

        cart.setUpdatedAt(System.currentTimeMillis());
        cartRepository.save(cart);
        return cart;
    }

    public Cart removeItem(String cartId, String productId) {
        Cart cart = cartRepository.findById(cartId);
        cart.getCartItems().removeIf(i -> i.getProductId().equals(productId));
        cart.setUpdatedAt(System.currentTimeMillis());
        cartRepository.save(cart);
        return cart;
    }


    public Cart updateItem(String cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId);
        Optional<CartItem> existingItem = cart.getCartItems().stream().filter(i -> i.getProductId().equals(item.getProductId())).findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(item.getQuantity());
            cart.setUpdatedAt(System.currentTimeMillis());
            cartRepository.save(cart);
        }
        return cart;
    }

    public Cart getCart(String cartId) {
        return cartRepository.findById(cartId);
    }

    public void deleteCart(String cartId) {
        cartRepository.delete(cartId);
    }

}
