package com.lesleyzh.dynamodb_cart_service.domain;

import java.util.List;

public class Cart {

    private String cartId; // The cart id of the cart
    private String userId; // The user id of the cart
    private List<CartItem> cartItems; // The list of cart items in the cart
    private long createdAt;
    private long updatedAt;
}
