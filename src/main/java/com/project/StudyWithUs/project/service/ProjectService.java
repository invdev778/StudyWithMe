package com.project.StudyWithUs.project.service;

import com.project.StudyWithUs.project.model.Project;
import com.project.StudyWithUs.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.ResponseCache;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // get project data
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    // create project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // get project one by id
    public ResponseEntity<Project> getProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist Project Data by id : ["+id+"]"));
        return ResponseEntity.ok(project);
    }

    // update board
    public ResponseEntity<Project> updateProject(
            Long id, Project updatedProject) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist Project Data by id : ["+id+"]"));
        project.setTitle(updatedProject.getTitle());
        project.setContent(updatedProject.getContent());
        project.setEnd_date(updatedProject.getEnd_date());
        project.setRep_image(updatedProject.getRep_image());

        Project endUpdatedProject = projectRepository.save(project);
        return ResponseEntity.ok(endUpdatedProject);
    }

    // delete project
    public ResponseEntity<Map<String, Boolean>> deleteProject(
            Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist Project Data by id : ["+id+"]"));

        projectRepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete Project Data By id : ["+id+"]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}