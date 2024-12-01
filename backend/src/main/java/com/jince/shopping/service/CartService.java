package com.jince.shopping.service;

import com.jince.shopping.model.Cart;
import com.jince.shopping.model.Item;
import com.jince.shopping.repository.CartRepository;
import com.jince.shopping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    public Cart getOrCreateCart(String customerName) {
        return cartRepository.findByCustomerName(customerName)
            .orElseGet(() -> {
                Cart newCart = new Cart(customerName, java.time.LocalDate.now().toString());
                return cartRepository.save(newCart);
            });
    }
    
    public Cart addItemToCart(String customerName, Long itemId, int quantity) {
        Cart cart = getOrCreateCart(customerName);
        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));
            
        for (Item cartItem : cart.getCartItems()) {
            if (cartItem.getId().equals(itemId)) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return cartRepository.save(cart);
            }
        }
    
        Item newItem = new Item(item.getName(), item.getDescription(), item.getPrice(), quantity);
        cart.getCartItems().add(newItem);
        return cartRepository.save(cart);
    }
    
    public Cart removeItemFromCart(String customerName, Long itemId) {
        Cart cart = getOrCreateCart(customerName);
        cart.getCartItems().removeIf(item -> item.getId().equals(itemId));
        return cartRepository.save(cart);
    }
}