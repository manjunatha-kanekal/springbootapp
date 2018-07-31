package com.mongo.springbootapp.controller;

import com.mongo.springbootapp.model.Employees;
import com.mongo.springbootapp.model.QEmployees;
import com.mongo.springbootapp.repository.EmployeesRepository;
import com.mongo.springbootapp.util.Constants;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public void insert(@RequestBody Employees employee) {
        this.employeesRepository.insert(employee);
    }

    /* Performing UPSERT */
    @PostMapping
    public void update(@RequestBody Employees employee){
        this.employeesRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.employeesRepository.deleteById(id);
    }

    @GetMapping("{/id}")
    public Employees getById(@PathVariable("id") String id) {
        Optional<Employees> employees = this.employeesRepository.findById(id);
        if(employees.isPresent()) {
            return employees.get();
        }
        return null;
    }

    @GetMapping("/department/{department}")
    public List<Employees> getByDepartment(@PathVariable("department") String department) {
        List<Employees> employees = this.employeesRepository.findByDepartment(department);
        return employees;
    }

    @GetMapping("/designation/{designation}")
    public List<Employees> getByDesignation(@PathVariable("designation") String designation) {
        List<Employees> employees = this.employeesRepository.findByDesignation(designation);
        return employees;
    }

    @GetMapping("/city/{city}")
    public List<Employees> getByCity(@PathVariable("city") String city) {
        QEmployees qEmployees = new QEmployees("Employees");
        BooleanExpression filterByCity = qEmployees.address.city.eq(city);

        List<Employees> employees = (List<Employees>) this.employeesRepository.findAll(filterByCity);
        return employees;
    }

    @GetMapping("/skill/{skill}/minrating/{minrating}")
    public List<Employees> getRecommendBySkill(@PathVariable("skill") String skill, @PathVariable("minrating") Optional<Integer> minRating) {
        int rating = Constants.DEFALUT_MIN_SKILL_RATING;
        if(minRating.isPresent()) {
            rating = minRating.get();
        }

        QEmployees qEmployees = new QEmployees("Employees");
        BooleanExpression filterBySkill = qEmployees.skillsets.any().skill.eq(skill);
        BooleanExpression filterByRating = qEmployees.skillsets.any().rating.gt(rating);

        List<Employees> employees = (List<Employees>) this.employeesRepository.findAll(filterBySkill.and(filterByRating));
        return employees;
    }

}
