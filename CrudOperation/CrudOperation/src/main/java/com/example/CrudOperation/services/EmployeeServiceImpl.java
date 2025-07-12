package com.example.CrudOperation.services;

import com.example.CrudOperation.Repositories.EmployeeRepository;
import com.example.CrudOperation.dao.EmployeeDAOJPAImpl;
import com.example.CrudOperation.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper mapper;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        var employee = repository.findById(id);

        if(!employee.isPresent()){
            throw new RuntimeException("Employee not found");
        }
        return employee.get();
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(0);
        }
        return repository.save(employee);
    }

    @Override
    public void delete(int id) {
        var employee = repository.findById(id);
        if(!employee.isPresent()){
            throw new RuntimeException("Employee not found");
        }
        repository.delete(employee.get());
    }

    @Override
    public boolean containsKey(Map<String, Object> patchPayload) {

        //Check if the client trying to change id, it's NOT ALLOWED
        return patchPayload.containsKey("id") ? true : false;
    }

    @Override
    public Employee apply(Map<String, Object> patchPayload, Employee employee) {

        //Convert object to json
        ObjectNode employeeNode = mapper.convertValue(employee,ObjectNode.class);

        //Convert patchPayLoad to json
        ObjectNode patchNode = mapper.convertValue(patchPayload,ObjectNode.class);

        //Merge the patch updates into employeeNode
        employeeNode.setAll(patchNode);

        return mapper.convertValue(employeeNode,Employee.class);
    }
}
