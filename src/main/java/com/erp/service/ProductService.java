package com.erp.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.model.Product;
import com.erp.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Product updateProduct(Product product) {
        // Check if product exists
        if (product.getId() != null) {
            Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
            
            // Update existing product fields
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            
            // Save the updated product
            return productRepository.save(existingProduct);
        }
        
        // If no ID, treat as new product
        return productRepository.save(product);
    }
}
