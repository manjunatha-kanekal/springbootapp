package com.mongo.springbootapp.repository;

import com.mongo.springbootapp.model.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends MongoRepository<Employees, String>, QuerydslPredicateExecutor<Employees> {
    List<Employees> findByDepartment(String department);
    List<Employees> findByDesignation(String designation);
}
