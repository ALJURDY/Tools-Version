package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.DependencyDto;
import com.wired.toolsVersion.Service.DependencyService;
import com.wired.toolsVersion.Service.RepositoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencies")
@RequiredArgsConstructor
public class DependencyController {

    private final DependencyService dependencyService;
    private final RepositoryService repositoryService;


    @GetMapping
    public List<DependencyDto> getAllDependencies() {
        return dependencyService.getAllDependencies();
    }

    @GetMapping("/**")
    public DependencyDto getDependencyByName(HttpServletRequest request) {
        return dependencyService.getDependencyByName(request.getRequestURI().split("dependencies/")[1]);
    }

    @GetMapping("/current-version/{repositoryId}/{dependencyId}")
    public String getCurrentVersionByName(@PathVariable Long repositoryId, @PathVariable Long dependencyId) {
        return "{\"currentVersion\": \"" + repositoryService.findCurrentVersionByRepositoryId(repositoryId, dependencyId) + "\"}";
    }

    @PostMapping
    public ResponseEntity<DependencyDto> createDependency(@Valid @RequestBody DependencyDto dependencyDto) {
        DependencyDto createdDependency = dependencyService.createDependency(dependencyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDependency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DependencyDto> updateDependency(@PathVariable Long id, @Valid @RequestBody DependencyDto dependencyDto) {
        DependencyDto updatedDependency = dependencyService.updateDependency(id, dependencyDto);
        return ResponseEntity.ok(updatedDependency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDependency(@PathVariable Long id) {
        dependencyService.deleteDependency(id);
        return ResponseEntity.noContent().build();
    }
}
