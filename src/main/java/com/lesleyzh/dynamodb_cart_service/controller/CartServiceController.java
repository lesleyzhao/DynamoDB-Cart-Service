package com.lesleyzh.dynamodb_cart_service.controller;

import com.lesleyzh.dynamodb_cart_service.domain.Cart;
import com.lesleyzh.dynamodb_cart_service.domain.CartItem;
import com.lesleyzh.dynamodb_cart_service.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/cart")
public class CartServiceController {
    //通过bean injection把service注入进来，来实现和service的互动
    private final CartService cartService;

    public CartServiceController(CartService cartService) {
        this.cartService = cartService;
    }

    //以下api都比较简单，实际开发中需要先做validation
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestParam String userId) {
        return ResponseEntity.ok(cartService.createCart(userId));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@RequestParam String cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }

    @PostMapping("/{cartId}/item")
    public ResponseEntity<Cart> addItem(@RequestParam String cartId, @RequestParam String productId, @RequestParam int quantity) {
        //validation
        if(quantity <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if(productId == null || productId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cartService.addItem(cartId, productId, quantity));
    }

    @DeleteMapping("/{cartId}/item")
    public ResponseEntity<Cart> removeItem(@RequestParam String cartId, @RequestParam String productId) {
        //validation
        if(productId == null || productId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cartService.removeItem(cartId, productId));
    }

    @PutMapping("/{cartId}/item")
    public ResponseEntity<Cart> updateItemQuantity(@RequestParam String productId, @RequestParam int quantity, @PathVariable String cartId) {
        //validation
        if(quantity <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if(productId == null || productId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cartService.updateItem(cartId, productId, quantity));
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Cart> deleteCart(@RequestParam String cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }
    
}
