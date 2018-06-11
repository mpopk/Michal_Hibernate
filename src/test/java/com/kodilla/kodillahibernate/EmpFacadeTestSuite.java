package com.kodilla.kodillahibernate;



import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import com.kodilla.kodillahibernate.manytomany.dao.EmployeeDao;
import com.kodilla.kodillahibernate.manytomany.facade.EmpFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpFacadeTestSuite {

    @Autowired
    private EmpFacade employment;
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;



    @Test
    public void findEmployeeByFragment() {
        // Given
        String fragment = "empl";
        List<Employee> employes = new ArrayList<>();
        employes.add(new Employee("Michael", "DFFFDempl"));
        employes.add(new Employee("John", "dfsdfempldff"));
        employes.add(new Employee("Paul", "emplCCCC"));
        // When
        List<Employee> employeeByLastNameFragment = employment.findEmployeeByLastNameFragment(fragment);
        //Then
        assertEquals(employes, employeeByLastNameFragment);
    }

    @Test
    public void findCompanyByFragment() {
        // Given
        String fragment = "comp";
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("compdfdf"));
        companies.add(new Company("dfdfsscomp"));
        companies.add(new Company("dfsdcompfsfd"));
        // When
        List<Company> companiesByFragment = employment.findCompanyByNameFragment(fragment);
        //Then
        assertEquals(companies, companiesByFragment);
    }


}
