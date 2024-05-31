package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.RepositoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryService {
    public List<RepositoryDto> getRepositoriesByProjectId(Long projectId) {
        // Logic to retrieve repositories by project ID
        return List.of(new RepositoryDto(1L, "Repo 1"), new RepositoryDto(2L, "Repo 2"));
    }

    public RepositoryDto getRepositoryById(Long id) {
        // Logic to get a repository by its ID
        return new RepositoryDto(id, "Repo " + id);
    }

    public RepositoryDto createRepository(RepositoryDto repositoryDto) {
        // Logic to create a new repository
        return repositoryDto;
    }

    public RepositoryDto updateRepository(Long id, RepositoryDto repositoryDto) {
        // Logic to update a repository
        return repositoryDto;
    }

    public void deleteRepository(Long id) {
        // Logic to delete a repository
    }
}
