package com.kodilla.kodillahibernate.manytomany.dao;


import com.kodilla.kodillahibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(value = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT(:prefix, '%') ORDER BY COMPANY_NAME")
    List<Company> compWithWithNamePrefix(String prefix);

    @Query(value = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT('%', :fragment, '%') ORDER BY COMPANY_NAME")
    List<Company> compWithNameFragment(String fragment);

}