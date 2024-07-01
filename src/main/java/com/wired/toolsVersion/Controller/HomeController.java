package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.ProjectDto;
import com.wired.toolsVersion.Dto.RepositoryDto;
import com.wired.toolsVersion.Service.ProjectService;
import com.wired.toolsVersion.Service.RepositoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final RepositoryService repositoryService;

    @GetMapping("/home")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/home/{projectId}/repositories")
    public List<RepositoryDto> getRepositoriesByProjectId(@PathVariable Long projectId) {
        return repositoryService.getRepositoriesByProjectId(projectId);
    }

    @GetMapping("/{projectId}")
    public ProjectDto getProjectById(@PathVariable Long projectId) { // Changed to projectId
        return projectService.getProjectById(projectId);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        ProjectDto createdProject = projectService.createProject(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProject(id, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
    // Handle favicon requests
    @GetMapping("/favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // No operation, just to prevent errors on favicon requests
    }
}
