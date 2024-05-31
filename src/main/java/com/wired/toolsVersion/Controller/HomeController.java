package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.ProjectDto;
import com.wired.toolsVersion.Dto.RepositoryDto;
import com.wired.toolsVersion.Service.ProjectService;
import com.wired.toolsVersion.Service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final RepositoryService repositoryService;

    @GetMapping("/projects")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{projectId}/repositories")
    public List<RepositoryDto> getRepositoriesByProjectId(@PathVariable Long projectId) {
        return repositoryService.getRepositoriesByProjectId(projectId);
    }
}
