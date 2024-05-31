package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.*;
import com.wired.toolsVersion.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class RepositoryController {

    private final RepositoryService repositoryService;
    private final DependencyService dependencyService;
    private final PluginService pluginService;

    @GetMapping("/{id}")
    public RepositoryDto getRepositoryById(@PathVariable Long id) {
        return repositoryService.getRepositoryById(id);
    }

    @PostMapping
    public RepositoryDto createRepository(@RequestBody RepositoryDto repositoryDto) {
        return repositoryService.createRepository(repositoryDto);
    }

    @PutMapping("/{id}")
    public RepositoryDto updateRepository(@PathVariable Long id, @RequestBody RepositoryDto repositoryDto) {
        return repositoryService.updateRepository(id, repositoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRepository(@PathVariable Long id) {
        repositoryService.deleteRepository(id);
    }

    @GetMapping("/{repositoryId}/dependencies")
    public List<DependencyDto> getDependenciesByRepositoryId(@PathVariable Long repositoryId) {
        return dependencyService.getDependenciesByRepositoryId(repositoryId);
    }

    @GetMapping("/{repositoryId}/plugins")
    public List<PluginDto> getPluginsByRepositoryId(@PathVariable Long repositoryId) {
        return pluginService.getPluginsByRepositoryId(repositoryId);
    }
}
