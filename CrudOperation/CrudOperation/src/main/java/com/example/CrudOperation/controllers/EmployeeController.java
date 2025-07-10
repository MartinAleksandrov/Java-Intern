package com.example.CrudOperation.controllers;

import com.example.CrudOperation.entity.Employee;
import com.example.CrudOperation.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String removeEmployee(@PathVariable int id) {
        employeeService.delete(id);

        return  "Employee with id " + id + " removed";
    }

    @PutMapping("/employees/{id}")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{id}")
    public Employee partialUpdateEmployee(@PathVariable int id , @RequestBody Map<String,Object> patchPayload) {

        Employee employee = employeeService.findById(id);

        if (employeeService.containsKey(patchPayload)) {
            throw new RuntimeException("Id is not allowed in request body");
        }

        var patch = employeeService.apply(patchPayload, employee);
        return  employeeService.save(patch);
    }
}