package com.example.hibernate;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Integer> {

    // void save (Employee var1);
    // Iterable<Employee> findAll();

}
