package com.mongo.springbootapp.controller;

import com.mongo.springbootapp.model.Employees;
import com.mongo.springbootapp.repository.EmployeesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("/all")
    public List<Employees> getAll() {
        List<Employees> employees = this.employeesRepository.findAll();
        return employees;
    }

}
