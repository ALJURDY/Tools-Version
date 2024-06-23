package com.wired.toolsVersion.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private String name;
    private String currentVersion;
    private String latestVersionUsed;
    private String latestRelease;
    private int useCount;

    @ManyToOne
    @JoinColumn(name = "repository_id")
    private Repository repository;
}

