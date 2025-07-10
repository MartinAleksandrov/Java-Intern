package com.example.CrudOperation.services;

import com.example.CrudOperation.entity.Employee;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
    boolean containsKey(Map<String, Object> patchPayload);
    Employee apply(Map<String, Object> patchPayload, Employee employee);
}
