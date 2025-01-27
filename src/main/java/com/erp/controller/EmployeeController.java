package com.erp.controller;

import com.erp.model.Employee;
import com.erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @PostMapping
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.existsById(id)) {
            employeeService.deleteById(id);
            return "success";
        }
        return "employee not found";
    }
}