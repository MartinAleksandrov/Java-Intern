package com.example.CrudOperation.dao;

import com.example.CrudOperation.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
//
//    private EntityManager em;
//
//    @Autowired
//    public EmployeeDAOJPAImpl(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        return em.find(Employee.class,id);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        return em.merge(employee);
//    }
//
//
//    @Override
//    public void delete(int id) {
//        Employee employee =  em.find(Employee.class,id);
//
//        em.remove(employee);
//    }
}