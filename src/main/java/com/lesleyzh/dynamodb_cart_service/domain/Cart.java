package com.lesleyzh.dynamodb_cart_service.domain;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@DynamoDbBean
public class Cart {

    private String cartId; // The cart id of the cart
    private String userId; // The user id of the cart
    private List<CartItem> cartItems; // The list of cart items in the cart
    private long createdAt;
    private long updatedAt;

    public Cart() {
    }

    public Cart(String cartId, String userId, List<CartItem> cartItems, long createdAt, long updatedAt) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("cartId")
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDbAttribute("cartItems")
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @DynamoDbAttribute("createdAt")
    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @DynamoDbAttribute("updatedAt")
    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

}
