package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResetController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/reset")
    @ResponseBody
    public String resetDatabase() {
        String sql = "TRUNCATE TABLE employees; TRUNCATE TABLE products; TRUNCATE TABLE orders; TRUNCATE TABLE order_item; TRUNCATE TABLE inventory;";
        jdbcTemplate.execute(sql);
        return "Database reset successfully";
    }
}
