package com.erp.controller;

import com.erp.model.Inventory;
import com.erp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String showInventory(Model model) {
        model.addAttribute("inventory", inventoryService.findAll());
        return "inventory";
    }

    @PostMapping
    @ResponseBody
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        return inventoryService.save(inventory);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteInventory(@PathVariable Long id) {
        if (inventoryService.existsById(id)) {
            inventoryService.deleteById(id);
            return "success";
        }
        return "inventory not found";
    }
}