package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.DependencyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependencyService {
    public List<DependencyDto> getDependenciesByRepositoryId(Long repositoryId) {
        // Logic to retrieve dependencies by repository ID
        return List.of(new DependencyDto("Dependency 1", "1.0", "2.0", "2.0"),
                new DependencyDto("Dependency 2", "1.0", "2.0", "2.0"));
    }
}
