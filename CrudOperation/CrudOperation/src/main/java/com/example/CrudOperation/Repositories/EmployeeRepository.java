package com.example.CrudOperation.Repositories;

import com.example.CrudOperation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
