package com.erp.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate = LocalDateTime.now();
    private String customerName;
    private String status;
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
