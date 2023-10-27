package com.ex.employee.service;

import com.ex.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long employeeId, Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    void deleteEmployee(Long employeeId);
}
