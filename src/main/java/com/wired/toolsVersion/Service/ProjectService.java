package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    public List<ProjectDto> getAllProjects() {
        // Logic to retrieve all projects
        return List.of(new ProjectDto(1L, "Project 1"), new ProjectDto(2L, "Project 2"));
    }
}

/*
* package com.wired.toolsVersion.Serviec;

import com.wired.toolsVersion.Dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    public List<ProjectDto> getAllProjects() {
        // Logic to retrieve all projects
        List<ProjectDto> projectDtos = new ArrayList<>();
        projectDtos.add(new ProjectDto(1L, "wired"));
        projectDtos.add(new ProjectDto(2L, "commons"));
        return projectDtos;
    }
}*/