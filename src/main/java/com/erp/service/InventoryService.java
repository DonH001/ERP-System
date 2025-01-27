package com.erp.service;

import com.erp.model.Inventory;
import com.erp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteById(Long id) {
        inventoryRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return inventoryRepository.existsById(id);
    }
}