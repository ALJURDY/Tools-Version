package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.ProjectDto;
import com.wired.toolsVersion.Dto.RepositoryDto;
import com.wired.toolsVersion.Service.ProjectService;
import com.wired.toolsVersion.Service.RepositoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HomeControllerTest {

    @Mock
    private ProjectService projectService;

    @Mock
    private RepositoryService repositoryService;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProjects() {
        List<ProjectDto> projects = List.of(new ProjectDto(1L, "Project 1"), new ProjectDto(2L, "Project 2"));
        when(projectService.getAllProjects()).thenReturn(projects);

        List<ProjectDto> result = homeController.getAllProjects();
        assertEquals(2, result.size());
        assertEquals("Project 1", result.get(0).getName());
    }

    @Test
    public void testGetRepositoriesByProjectId() {
        List<RepositoryDto> repositories = List.of(new RepositoryDto(1L, "icon", "Repo 1","50", 1L, List.of(),List.of()));
        when(repositoryService.getRepositoriesByProjectId(1L)).thenReturn(repositories);

        List<RepositoryDto> result = homeController.getRepositoriesByProjectId(1L);
        assertEquals(1, result.size());
        assertEquals("Repo 1", result.get(0).getName());
    }

    @Test
    public void testCreateProject() {
        ProjectDto projectDto = new ProjectDto(1L, "New Project");
        when(projectService.createProject(projectDto)).thenReturn(projectDto);

        ResponseEntity<ProjectDto> response = homeController.createProject(projectDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("New Project", response.getBody().getName());
    }

    @Test
    public void testUpdateProject() {
        ProjectDto projectDto = new ProjectDto(1L, "Updated Project");
        when(projectService.updateProject(1L, projectDto)).thenReturn(projectDto);

        ResponseEntity<ProjectDto> response = homeController.updateProject(1L, projectDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Project", response.getBody().getName());
    }

    @Test
    public void testDeleteProject() {
        ResponseEntity<Void> response = homeController.deleteProject(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
