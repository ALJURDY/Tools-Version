package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.PluginDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PluginService {
    public List<PluginDto> getPluginsByRepositoryId(Long repositoryId) {
        // Logic to retrieve plugins by repository ID
        return List.of(new PluginDto("Plugin 1", "1.0", "2.0", "2.0"),
                new PluginDto("Plugin 2", "1.0", "2.0", "2.0"));
    }
}

