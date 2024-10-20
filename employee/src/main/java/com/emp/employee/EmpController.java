package com.emp.employee;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:3000/")
public class EmpController {
  
    // Employee emp = new Employee("aditya", "3030", "adity@gmail.com");
     //EmployeeService employeeService = new EmployeeServiceimpl() ;
    @Autowired 
    EmployeeService employeeService;
    

   

    

   //get mapping
    @GetMapping("employees")
    public List<Employee> getMethodName() {
        return employeeService.readEmployee();
    }

    @GetMapping("employees/{id}")
    public Employee getMethodName(@PathVariable long id) {
        return employeeService.readOneEmployee(id);
    }
    

//Add mapping
    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee employee) {

        employeeService.createEmployee(employee);
        return "Add sucessfully";
    }
//Delete mapping
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
           if(employeeService.deleteEmployee(id))
           return "Delete sucessfully";

        return "Not Deleted";
    }

    //update mapping
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        
        
        return employeeService.updataEmployee(id, employee);
    }
}
