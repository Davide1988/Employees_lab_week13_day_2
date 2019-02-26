package com.example.employeeservice.controller;


import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")

public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


//    @PostMapping("/employees")
//    public void createStudent(@RequestBody Employee employee) {
//        Employee savedEmployee = employeeRepository.save(employee);
//
//
////        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
////                .buildAndExpand(savedEmployee.getId()).toUri();
////
////        return ResponseEntity.created(location).build();
//
//
//    }


    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }


    @GetMapping("{id}")
    public Optional<Employee> getEmployeeWithId(@PathVariable Long id){
        return employeeRepository.findById(id);
    }


    @DeleteMapping("delete/{id}")
    public void deleteEmployeeWithId(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
}