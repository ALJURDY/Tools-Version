package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.RepositoryDto;
import com.wired.toolsVersion.Model.Project;
import com.wired.toolsVersion.Model.Repository;
import com.wired.toolsVersion.Repository.ProjectRepository;
import com.wired.toolsVersion.Repository.RepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RepositoryService {

    @Autowired
    private RepositoryRepository repositoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public RepositoryDto getRepositoryByName(String name) {
        Repository repository = repositoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Repository not found"));
        return convertToDto(repository);
    }
    public List<RepositoryDto> getRepositoriesByProjectId(Long projectId) {
        return repositoryRepository.findByProjectId(projectId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public RepositoryDto createRepository(RepositoryDto repositoryDto) {
        Project project = projectRepository.findById(repositoryDto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Repository repository = new Repository();
        repository.setName(repositoryDto.getName());
        repository.setIcon(repositoryDto.getIcon());
        repository.setPercentage(repositoryDto.getPercentage());
        repository.setProject(project);

        if (repositoryDto.getId() != null) {
            throw new IllegalArgumentException("ID should not be set for new repositories");
        }

        repository = repositoryRepository.save(repository);
        return convertToDto(repository);
    }

    @Transactional
    public RepositoryDto updateRepository(Long id, RepositoryDto repositoryDto) {
        Repository repository = repositoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repository not found"));

        repository.setName(repositoryDto.getName());
        repository.setIcon(repositoryDto.getIcon());
        repository.setPercentage(repositoryDto.getPercentage());

        repository = repositoryRepository.save(repository);
        return convertToDto(repository);
    }

    @Transactional
    public void deleteRepository(Long id) {
        repositoryRepository.deleteById(id);
    }

    private RepositoryDto convertToDto(Repository repository) {
        RepositoryDto repositoryDto = new RepositoryDto();
        repositoryDto.setId(repository.getId());
        repositoryDto.setIcon(repository.getIcon());
        repositoryDto.setName(repository.getName());
        repositoryDto.setPercentage(repository.getPercentage());
        repositoryDto.setProjectId(repository.getProject().getId());
        return repositoryDto;
    }

}
