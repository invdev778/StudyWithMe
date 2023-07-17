package com.project.StudyWithUs.project.repository;

import java.util.List;
import com.project.StudyWithUs.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}