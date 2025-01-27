package com.erp.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
    private Integer quantity;
    private Double price;
}
