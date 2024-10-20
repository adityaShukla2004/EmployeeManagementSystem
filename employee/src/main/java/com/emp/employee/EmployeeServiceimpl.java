package com.emp.employee;

import java.util.ArrayList;
import java.util.List;

//import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EmployeeServiceimpl implements EmployeeService {

    


     // Employee Repository
     @Autowired
     EmployeeRepository employeeRepository;


    

    @Override
    public List<Employee> readEmployee() {
       
        List <EmployeeEntity> employeesList= employeeRepository.findAll();
       
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity  employeeEntity: employeesList) {
            Employee emp = new Employee();
            emp.setEmail(employeeEntity.getEmail());
            emp.setName(employeeEntity.getName());
            emp.setId(employeeEntity.getId());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
       
       // employees.add(employee);
       EmployeeEntity employeeEntity = new EmployeeEntity();
       BeanUtils.copyProperties(employee, employeeEntity);
       employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public boolean deleteEmployee(Long empId) {
       
        
       EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        employeeRepository.delete(employeeEntity);
      //  employees = this.employees.stream().filter(e -> e.getId() != empId).collect(Collectors.toList());
       
        return true;
      
    }

    @Override
    public String updataEmployee(long id, Employee sEmployee) {

       EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

       employeeEntity.setEmail(sEmployee.getEmail());
       employeeEntity.setName(sEmployee.getName());
       employeeEntity.setPhone(sEmployee.getPhone());

       employeeRepository.save(employeeEntity);

         return "Updated successfully";
    }

    @Override
    public Employee readOneEmployee(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
        
    }

    
}
