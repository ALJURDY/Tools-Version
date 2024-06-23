package com.wired.toolsVersion.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryDto {

    private Long id;

    private String icon;

    @NotNull
    private String name;

    @NotNull
    private Integer percentage;

    @NotNull
    private Long projectId;
}