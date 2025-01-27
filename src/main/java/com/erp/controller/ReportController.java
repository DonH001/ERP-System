package com.erp.controller;

import com.erp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public String showReports(Model model) {
        model.addAttribute("salesReport", reportService.generateSalesReport());
        model.addAttribute("inventoryReport", reportService.generateInventoryReport());
        return "reports";
    }
}