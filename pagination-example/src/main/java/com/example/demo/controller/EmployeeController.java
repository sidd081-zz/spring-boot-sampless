package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    /**
     *
     * REQUEST EXAMPLE :
     *
     * Basic one
     * 1. http://localhost:8080/employee
     *
     * If you need to change the page size from 5(which we have set as default in application.properties) to 10
     * 2. http://localhost:8080/employee?size=10
     *
     * To get next page
     * 3. http://localhost:8080/employee?page=1
     *
     * To sort on any field
     * 4. http://localhost:8080/employee?size=10&sort=name
     */
    @GetMapping
    public @ResponseBody
    Page<Employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }



}
