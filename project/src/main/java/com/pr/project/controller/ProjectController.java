package com.pr.project.controller;

import com.pr.project.model.Project;
import com.pr.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
@Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProject()
    {
        return projectService.getAllProject();

    }
    @GetMapping("/project/{projectId}")
    private Project getProject(@PathVariable("projectId") int projectId)
    {
        return projectService.getProjectById(projectId);

    }
    @DeleteMapping("/project/{projectId}")
    private void deleteProject(@PathVariable("projectId") int projectId)
    {
        projectService.delete(projectId);
    }
    @PostMapping("/project")
    private int saveProject(@RequestBody Project project)
    {
        projectService.saveOrUpdate(project);
        return project.getProjectId();
    }
    @PutMapping("/project")
    private Project update(@RequestBody Project project)
    {
        projectService.saveOrUpdate(project);
        return project;
    }
}
