package com.wired.toolsVersion.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String icon;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "current_version", length = 15)
    private String currentVersion;

    @Column(name = "latest_version_used", length = 15)
    private String latestVersionUsed;

    @Column(name = "latest_release", length = 15)
    private String latestRelease;

    @Column(nullable = false, length = 15)
    private int use_count;

    @ManyToMany(mappedBy = "dependencies")
    private List<Repository> repositories;
}

