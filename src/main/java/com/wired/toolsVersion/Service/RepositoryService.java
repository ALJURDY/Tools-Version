package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.DependencyDto;
import com.wired.toolsVersion.Dto.RepositoryDto;
import com.wired.toolsVersion.Dto.VersionDto;
import com.wired.toolsVersion.Model.Project;
import com.wired.toolsVersion.Model.RepoDependency;
import com.wired.toolsVersion.Model.Repository;
import com.wired.toolsVersion.Repository.ProjectRepository;
import com.wired.toolsVersion.Repository.RepoDependencyRepository;
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
    @Autowired
    private RepoDependencyRepository repoDependencyRepository;

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

    public String findCurrentVersionByRepositoryId(Long repositoryId, Long dependencyId) {
        System.out.println("Searching current version ...................");
        System.out.println("repositoryId = " + repositoryId);
        System.out.println("dependencyId = " + dependencyId);
        RepoDependency repoDependency = repoDependencyRepository.findCurrentVersionByRepositoryIdAndDependencyId(repositoryId, dependencyId)
                .orElseThrow(() -> new RuntimeException("RepoDependency not found"));
        return repoDependency.getCurrentVersion();
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

        // Convert dependencies
        List<DependencyDto> dependencyDtos = repository.getDependencies().stream().map(dependency -> {
            DependencyDto dependencyDto = new DependencyDto();
            dependencyDto.setId(dependency.getDependency().getId());
            dependencyDto.setIcon(dependency.getDependency().getIcon());
            dependencyDto.setName(dependency.getDependency().getName());
            dependencyDto.setLatestVersionUsed(dependency.getDependency().getLatestVersionUsed());
            dependencyDto.setLatestRelease(dependency.getDependency().getLatestRelease());
            dependencyDto.setUseCount(dependency.getDependency().getUseCount());

            // Map current versions
            List<VersionDto> versionDtos = dependency.getDependency().getRepositories().stream().map(repoDependency -> {
                VersionDto versionDto = new VersionDto();
                versionDto.setVersionNumber(repoDependency.getCurrentVersion());
                versionDto.setRepositoryNames(
                        repoDependency.getDependency().getRepositories().stream()
                                .map(x -> x.getRepository().getName())
                                .collect(Collectors.toList())
                );
                return versionDto;
            }).collect(Collectors.toList());

            dependencyDto.setCurrentVersions(versionDtos);
            return dependencyDto;
        }).collect(Collectors.toList());

        repositoryDto.setDependencies(dependencyDtos);

        //        repositoryDto.setPlugins(repository.getPlugins().stream()
        //                .map(plugin -> new PluginDto(
        //                        plugin.getPlugin().getId(),
        //                        plugin.getPlugin().getIcon(),
        //                        plugin.getPlugin().getName(),
        //                        // je mets quoi ici
        //                        plugin.getPlugin().getLatestVersionUsed(),
        //                        plugin.getPlugin().getLatestRelease(),
        //                        plugin.getPlugin().getUseCount()))
        //                .collect(Collectors.toList()));
        return repositoryDto;
    }
}
