package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Dto.PluginDto;
import com.wired.toolsVersion.Service.PluginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plugins")
@RequiredArgsConstructor
public class PluginController {

    private final PluginService pluginService;

    @GetMapping
    public List<PluginDto> getAllPlugins() {
        return pluginService.getAllPlugins();
    }

    @GetMapping("/plugins/{id}")
    public PluginDto getPluginById(@PathVariable Long id) {
        return pluginService.getPluginById(id);
    }

    @PostMapping
    public ResponseEntity<PluginDto> createPlugin(@Valid @RequestBody PluginDto pluginDto) {
        PluginDto createdPlugin = pluginService.createPlugin(pluginDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlugin);
    }

    @PutMapping("/plugins/{id}")
    public ResponseEntity<PluginDto> updatePlugin(@PathVariable Long id, @Valid @RequestBody PluginDto pluginDto) {
        PluginDto updatedPlugin = pluginService.updatePlugin(id, pluginDto);
        return ResponseEntity.ok(updatedPlugin);
    }

    @DeleteMapping("/plugins/{id}")
    public ResponseEntity<Void> deletePlugin(@PathVariable Long id) {
        pluginService.deletePlugin(id);
        return ResponseEntity.noContent().build();
    }
}
