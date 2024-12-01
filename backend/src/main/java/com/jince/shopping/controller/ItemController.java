package com.jince.shopping.controller;

import com.jince.shopping.model.Item;
import com.jince.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return ResponseEntity.ok(savedItem);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}