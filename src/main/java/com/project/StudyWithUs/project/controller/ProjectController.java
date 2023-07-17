package com.project.StudyWithUs.project.controller;

import com.project.StudyWithUs.project.model.Project;
import com.project.StudyWithUs.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // get all project
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProject();
    }

    // create project
    @PostMapping("/projects")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // get project one by id
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(
            @PathVariable Long id) {
        return projectService.getProject(id);
    }

    // update project
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProjectById(
            @PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    // delete board
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProjectById(
            @PathVariable Long id) {
        return projectService.deleteProject(id);
    }
}