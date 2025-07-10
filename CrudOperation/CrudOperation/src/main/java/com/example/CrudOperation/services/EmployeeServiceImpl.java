package com.example.CrudOperation.services;

import com.example.CrudOperation.dao.EmployeeDAOJPAImpl;
import com.example.CrudOperation.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAOJPAImpl daojpa;
    private final ObjectMapper mapper;


    @Autowired
    public EmployeeServiceImpl(EmployeeDAOJPAImpl daojpa, ObjectMapper mapper) {
        this.daojpa = daojpa;
        this.mapper = mapper;
    }

    @Override
    public List<Employee> findAll() {
        return daojpa.findAll();
    }

    @Override
    public Employee findById(int id) {
        var employee = daojpa.findById(id);

        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        return daojpa.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(0);
        }
        return daojpa.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Employee employee = daojpa.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        daojpa.delete(id);
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
