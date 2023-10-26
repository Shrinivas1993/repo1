package com.pr.project.model;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.RequiredTypes;

@Entity
@Table(name = "project_details")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    private  String projectName;

    private String projectDesc;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }
}
