package com.dr.department.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department_details")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    private  String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
