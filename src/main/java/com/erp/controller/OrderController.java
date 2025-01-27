package com.erp.controller;

import com.erp.model.Order;
import com.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @PostMapping
    @ResponseBody
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable Long id) {
        if (orderService.existsById(id)) {
            orderService.deleteById(id);
            return "success";
        }
        return "order not found";
    }
}
