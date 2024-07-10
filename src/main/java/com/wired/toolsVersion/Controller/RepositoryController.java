package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.*;
import com.wired.toolsVersion.Service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
@Validated
public class RepositoryController {

    private final RepositoryService repositoryService;
    private final DependencyService dependencyService;
    private final PluginService pluginService;

    @GetMapping("/{name}")
    public ResponseEntity<RepositoryDto> getRepositoryByName(@PathVariable String name) {
        RepositoryDto repositoryDto = repositoryService.getRepositoryByName(name);
        return ResponseEntity.ok(repositoryDto);
    }

    @PostMapping
    public ResponseEntity<RepositoryDto> createRepository(@Valid @RequestBody RepositoryDto repositoryDto) {
        RepositoryDto createdRepository = repositoryService.createRepository(repositoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRepository);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepositoryDto> updateRepository(@PathVariable Long id, @Valid @RequestBody RepositoryDto repositoryDto) {
        RepositoryDto updatedRepository = repositoryService.updateRepository(id, repositoryDto);
        return ResponseEntity.ok(updatedRepository);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepository(@PathVariable Long id) {
        repositoryService.deleteRepository(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{repositoryId}/dependencies")
    public ResponseEntity<List<DependencyDto>> getDependenciesByRepositoryId(@PathVariable Long repositoryId) {
        List<DependencyDto> dependencies = dependencyService.getDependenciesByRepositoryId(repositoryId);
        return ResponseEntity.ok(dependencies);
    }

    @GetMapping("/{repositoryId}/plugins")
    public ResponseEntity<List<PluginDto>> getPluginsByRepositoryId(@PathVariable Long repositoryId) {
        List<PluginDto> plugins = pluginService.getPluginsByRepositoryId(repositoryId);
        return ResponseEntity.ok(plugins);
    }
}
