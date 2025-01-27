package com.erp.controller;

import com.erp.model.Product;
import com.erp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @PostMapping
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "success";
        }
        return "product not found";
    }
}
