package com.ex.employee.serviceImpl;

import com.ex.employee.model.Department;
import com.ex.employee.model.Employee;
import com.ex.employee.repository.EmployeeRepository;
import com.ex.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        if (employeeRepository.existsById(employeeId)) {
            updatedEmployee.setEmployeeId(employeeId);
            return employeeRepository.save(updatedEmployee);
        }
        return null; // Handle not found
    }

    @Override
    public List<Employee> getAllEmployees() {

        //Calling department service
        String url="http://localhost:8082/departments";
        List<Department>list=restTemplate.getForObject(url, ArrayList.class);
        System.out.println(list);
        /*Iterable<Employee>itr=employeeRepository.findAll();
        List<Employee> lis= Streamable.of(itr).toList();
        */return (List<Employee>) employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(Long employeeId) {
        ResponseEntity<Department> responseEntity=restTemplate.getForEntity("http://localhost:8082/department/2", Department.class);
        Department d=responseEntity.getBody();
        List<Department> list=new ArrayList<>();
        list.add(d);
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee emp=optionalEmployee.get();
        emp.setList(list);
        System.out.println(emp.getEmployeeId());
       return optionalEmployee.orElse(null); // Handle not found

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
