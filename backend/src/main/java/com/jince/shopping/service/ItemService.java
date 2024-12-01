package com.jince.shopping.service;

import com.jince.shopping.model.Item;
import com.jince.shopping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
    
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}