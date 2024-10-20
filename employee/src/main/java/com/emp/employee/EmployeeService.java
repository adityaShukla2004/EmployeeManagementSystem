package com.emp.employee;

import java.util.List;

public interface EmployeeService {
    
    List <Employee> readEmployee();
    Employee createEmployee(Employee employee);
    boolean deleteEmployee(Long id);
    String updataEmployee(long id,Employee sEmployee);
    Employee readOneEmployee(long id);
}
