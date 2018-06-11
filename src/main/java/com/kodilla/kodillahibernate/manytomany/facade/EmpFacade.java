package com.kodilla.kodillahibernate.manytomany.facade;


import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import com.kodilla.kodillahibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpFacade {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    @Autowired
    public EmpFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }



    public List<Company> findCompanyByNameFragment(String fragment) {
        List<Company> result = null;
        result = companyDao.compWithNameFragment(fragment);
        return result;
    }

    public List<Employee> findEmployeeByLastNameFragment(String fragment) {
        List<Employee> result = null;
        result =  employeeDao.empWithLastNameFragment(fragment);
        return result;
    }
}
