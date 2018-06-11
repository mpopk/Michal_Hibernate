package com.kodilla.kodillahibernate.manytomany.dao;


import com.kodilla.kodillahibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query( value = "SELECT FROM Employee WHERE lastname = :lastName ORDER BY lastname, firstname")
    List<Employee> empWithLastName(@Param("lastName") String lastName);

    @Query( value = "SELECT FROM Employee WHERE lastname LIKE CONCAT('%', :fragment, '%') ORDER BY lastname, firstname")
    List<Employee> empWithLastNameFragment(@Param("fragment") String fragment);
}