package com.wired.toolsVersion.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionDto {
    String versionNumber;
    List<String> repositoryNames;
}
 