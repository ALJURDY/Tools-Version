package com.wired.toolsVersion.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryDto {

    private Long id;

    private String icon;

    @NotNull
    private String name;

    @NotNull
    private String percentage;

    @NotNull
    private Long projectId;

    private List <DependencyDto> dependencies;
    private List <PluginDto> plugins;
}