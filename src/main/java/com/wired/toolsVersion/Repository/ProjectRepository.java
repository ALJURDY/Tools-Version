package com.wired.toolsVersion.Repository;


import com.wired.toolsVersion.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

