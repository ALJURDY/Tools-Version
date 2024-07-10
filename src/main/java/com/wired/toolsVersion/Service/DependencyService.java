package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.DependencyDto;
import com.wired.toolsVersion.Model.Dependency;
import com.wired.toolsVersion.Repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependencyService {

    @Autowired
    private DependencyRepository dependencyRepository;

    public List<DependencyDto> getAllDependencies() {
        return dependencyRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public DependencyDto getDependencyById(Long id) {
        Dependency dependency = dependencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dependency not found"));
        return convertToDto(dependency);
    }

    public DependencyDto getDependencyByName(String name) {
        Dependency dependency = dependencyRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Dependency not found"));
        return convertToDto(dependency);
    }

    public List<DependencyDto> getDependenciesByRepositoryId(Long repositoryId) {
        return dependencyRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public DependencyDto createDependency(DependencyDto dependencyDto) {
        Dependency dependency = new Dependency();
        dependency.setName(dependencyDto.getName());
        dependency.setIcon(dependencyDto.getIcon());
        dependency.setCurrentVersion(dependencyDto.getCurrentVersion());
        dependency.setLatestVersionUsed(dependencyDto.getLatestVersionUsed());
        dependency.setLatestRelease(dependencyDto.getLatestRelease());
        dependency.setUse_count(dependencyDto.getUse_count());

        dependency = dependencyRepository.save(dependency);
        return convertToDto(dependency);
    }

    @Transactional
    public DependencyDto updateDependency(Long id, DependencyDto dependencyDto) {
        Dependency dependency = dependencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dependency not found"));

        dependency.setName(dependencyDto.getName());
        dependency.setIcon(dependencyDto.getIcon());
        dependency.setCurrentVersion(dependencyDto.getCurrentVersion());
        dependency.setLatestVersionUsed(dependencyDto.getLatestVersionUsed());
        dependency.setLatestRelease(dependencyDto.getLatestRelease());
        dependency.setUse_count(dependencyDto.getUse_count());

        dependency = dependencyRepository.save(dependency);
        return convertToDto(dependency);
    }

    @Transactional
    public void deleteDependency(Long id) {
        dependencyRepository.deleteById(id);
    }

    private DependencyDto convertToDto(Dependency dependency) {
        DependencyDto dependencyDto = new DependencyDto();
        dependencyDto.setId(dependency.getId());
        dependencyDto.setName(dependency.getName());
        dependencyDto.setIcon(dependency.getIcon());
        dependencyDto.setCurrentVersion(dependency.getCurrentVersion());
        dependencyDto.setLatestVersionUsed(dependency.getLatestVersionUsed());
        dependencyDto.setLatestRelease(dependency.getLatestRelease());
        dependencyDto.setUse_count(dependency.getUse_count());
        return dependencyDto;
    }


}
