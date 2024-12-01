package com.jince.shopping.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.jince.shopping.model.Item;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerName;

    @Column(name = "cart_date")
    private String currentDate;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private List<Item> cartItems = new ArrayList<>();
    
    public Cart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2016";
        this.cartItems = new ArrayList<>();
    }
    
    public Cart(String name, String date) {
        this.customerName = name;
        this.currentDate = date;
        this.cartItems = new ArrayList<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getCurrentDate() { return currentDate; }
    public void setCurrentDate(String currentDate) { this.currentDate = currentDate; }
    
    public List<Item> getCartItems() { return cartItems; }
    public void setCartItems(List<Item> cartItems) { this.cartItems = cartItems; }

    public int getCostOfCart() {
        return cartItems.stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
    
    public int getNumItemsInCart() {
        return cartItems.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }
}