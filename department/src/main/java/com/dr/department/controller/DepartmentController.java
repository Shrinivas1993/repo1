package com.dr.department.controller;

import com.dr.department.model.Department;
import com.dr.department.service.DepartmentService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllProject()
    {
        return departmentService.getAllDepartment();

    }
    @GetMapping("/department/{deptId}")
    private Department getProject(@PathVariable("deptId") int deptId)
    {
        return departmentService.getDepartmentById(deptId);

    }
    @DeleteMapping("/department/{deptId}")
    private void deleteProject(@PathVariable("deptId") int deptId)
    {
        departmentService.delete(deptId);
    }
    @PostMapping("/department")
    private int saveProject(@RequestBody Department department)
    {
        departmentService.saveOrUpdate(department);
        return department.getDeptId();
    }
    @PutMapping("/department")
    private Department update(@RequestBody Department department)
    {
        departmentService.saveOrUpdate(department);
        return department;
    }
}
