package com.wired.toolsVersion.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PluginDto {


    private Long id;

    private String icon;

    @NotNull
    private String name;

    @NotNull
    private String currentVersion;

    @NotNull
    private String latestVersionUsed;

    @NotNull
    private String latestRelease;

    @NotNull
    private int useCount;
}
