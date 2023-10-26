package com.dr.department.service;

import com.dr.department.model.Department;
import com.dr.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment()
    {
        List<Department> department = new ArrayList<>();
        departmentRepository.findAll().forEach(department1 -> department.add(department1));
        return department;
    }

    public Department getDepartmentById(int deptId)
    {
        return departmentRepository.findById(deptId).get();
    }

    public void delete(int deptId)
    {
        departmentRepository.deleteById(deptId);
    }
    public void saveOrUpdate(Department department)
    {
        departmentRepository.save(department);
    }
    public void update(Department department, int deptId)
    {
        departmentRepository.save(department);
    }

}
