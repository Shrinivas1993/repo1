package com.pr.project.service;

import com.pr.project.model.Project;
import com.pr.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProject()
    {
        List<Project> project = new ArrayList<>();
        projectRepository.findAll().forEach(project1 -> project.add(project1));
        return project;
    }

    public Project getProjectById(int projectId)
    {
        return projectRepository.findById(projectId).get();
    }

    public void delete(int projectId)
    {
        projectRepository.deleteById(projectId);
    }
    public void saveOrUpdate(Project project)
    {
        projectRepository.save(project);
    }
    public void update(Project project, int projectId)
    {
        projectRepository.save(project);
    }
}
