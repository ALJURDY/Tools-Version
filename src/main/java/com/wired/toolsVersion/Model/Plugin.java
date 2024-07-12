package com.wired.toolsVersion.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plugin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(name = "latest_version_used", nullable = false, length = 15)
    private String latestVersionUsed;

    @Column(name = "latest_release", nullable = false, length = 15)
    private String latestRelease;

    @Column(name = "useCount", nullable = false, length = 15)
    private int useCount;

    @OneToMany(mappedBy = "plugin")
    private List<RepoPlugin> repositories;
}

