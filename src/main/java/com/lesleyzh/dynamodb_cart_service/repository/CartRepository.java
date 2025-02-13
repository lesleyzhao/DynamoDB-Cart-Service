package com.lesleyzh.dynamodb_cart_service.repository;

import com.lesleyzh.dynamodb_cart_service.domain.Cart;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class CartRepository {


    // Bean Injection来注入DynamodbConfig中的amazonDynamoDB client和enhancedClient
    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<Cart> cartTable;

    public CartRepository(DynamoDbEnhancedClient enhancedClient) {
        this.enhancedClient = enhancedClient;
        this.cartTable = enhancedClient.table("Cart", TableSchema.fromBean(Cart.class));
        // TableSchema.fromBean(Cart.class) → Maps the Cart Java class to the table structure
    }

    public Cart findById(String cartId) {
        Key key = Key.builder().partitionValue(cartId).build();
        return cartTable.getItem(key);
    }

    public void save(Cart cart) {
        cart.setUpdatedAt(System.currentTimeMillis());
        cartTable.putItem(cart);
    }

    public void delete(String cartId) {
        Key key = Key.builder().partitionValue(cartId).build();
        cartTable.deleteItem(key);
    }
}
