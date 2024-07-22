package com.wired.toolsVersion.Service;

import com.wired.toolsVersion.Dto.PluginDto;
import com.wired.toolsVersion.Model.Plugin;
import com.wired.toolsVersion.Repository.PluginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;

    public List<PluginDto> getAllPlugins() {
        return pluginRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PluginDto getPluginById(Long id) {
        Plugin plugin = pluginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plugin not found"));
        return convertToDto(plugin);
    }

    public List<PluginDto> getPluginsByRepositoryId(Long repositoryId) {
        return pluginRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PluginDto createPlugin(PluginDto pluginDto) {
        Plugin plugin = new Plugin();
        plugin.setName(pluginDto.getName());
        plugin.setIcon(pluginDto.getIcon());
        plugin.setLatestVersionUsed(pluginDto.getLatestVersionUsed());
        plugin.setLatestRelease(pluginDto.getLatestRelease());
        plugin.setUseCount(pluginDto.getUseCount());

        plugin = pluginRepository.save(plugin);
        return convertToDto(plugin);
    }

    @Transactional
    public PluginDto updatePlugin(Long id, PluginDto pluginDto) {
        Plugin plugin = pluginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plugin not found"));

        plugin.setName(pluginDto.getName());
        plugin.setIcon(pluginDto.getIcon());
        plugin.setLatestVersionUsed(pluginDto.getLatestVersionUsed());
        plugin.setLatestRelease(pluginDto.getLatestRelease());
        plugin.setUseCount(pluginDto.getUseCount());

        plugin = pluginRepository.save(plugin);
        return convertToDto(plugin);
    }

    @Transactional
    public void deletePlugin(Long id) {
        pluginRepository.deleteById(id);
    }

    private PluginDto convertToDto(Plugin plugin) {
        PluginDto pluginDto = new PluginDto();
        pluginDto.setId(plugin.getId());
        pluginDto.setName(plugin.getName());
        pluginDto.setIcon(plugin.getIcon());
        pluginDto.setLatestVersionUsed(plugin.getLatestVersionUsed());
        pluginDto.setLatestRelease(plugin.getLatestRelease());
        pluginDto.setUseCount(plugin.getUseCount());
        return pluginDto;
    }
}
