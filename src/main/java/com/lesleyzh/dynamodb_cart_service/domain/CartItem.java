package com.lesleyzh.dynamodb_cart_service.domain;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;

@DynamoDbBean
public class CartItem { // This class is used to represent a cart item in the cart service

    private String productId; // The product id of the cart item
    //不需要在这里存储product的其他信息，用id去product表里查就行
    private String productName; // The product name of the cart item
    private int quantity; // The quantity of the cart item
    private BigDecimal price; // The price of the cart item
    //注意要是在实际开发中不能用double，因为double会有精度问题，用BigDecimal

    public CartItem() {
    }

    public CartItem(String productId, String productName, int quantity, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @DynamoDbAttribute("productId")
    public String getProductId() {
        return productId;
    }

    @DynamoDbAttribute("productName")
    public String getProductName() {
        return productName;
    }

    @DynamoDbAttribute("quantity")
    public int getQuantity() {
        return quantity;
    }

    @DynamoDbAttribute("price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
