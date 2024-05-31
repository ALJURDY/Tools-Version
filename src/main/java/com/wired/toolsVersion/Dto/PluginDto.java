package com.wired.toolsVersion.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PluginDto {
    private String name;
    private String usedVersion;
    private String currentVersion;
    private String latestRelease;
}
