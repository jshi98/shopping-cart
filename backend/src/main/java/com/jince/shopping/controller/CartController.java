package com.jince.shopping.controller;

import com.jince.shopping.model.Cart;
import com.jince.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @GetMapping("/{customerName}")
    public ResponseEntity<Cart> getCart(@PathVariable String customerName) {
        Cart cart = cartService.getOrCreateCart(customerName);
        return ResponseEntity.ok(cart);
    }
    
    @PostMapping("/{customerName}/items/{itemId}")
    public ResponseEntity<Cart> addToCart(
            @PathVariable String customerName,
            @PathVariable Long itemId,
            @RequestParam(defaultValue = "1") int quantity) {
        Cart updatedCart = cartService.addItemToCart(customerName, itemId, quantity);
        return ResponseEntity.ok(updatedCart);
    }
    
    @DeleteMapping("/{customerName}/items/{itemId}")
    public ResponseEntity<Cart> removeFromCart(
            @PathVariable String customerName,
            @PathVariable Long itemId) {
        Cart updatedCart = cartService.removeItemFromCart(customerName, itemId);
        return ResponseEntity.ok(updatedCart);
    }
}