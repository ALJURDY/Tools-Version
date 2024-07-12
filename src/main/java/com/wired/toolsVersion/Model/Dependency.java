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

    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(name = "latest_version_used", length = 15)
    private String latestVersionUsed;

    @Column(name = "latest_release", length = 15)
    private String latestRelease;

    @Column(name = "use_count", nullable = false, length = 15)
    private int useCount;

    @OneToMany(mappedBy = "dependency")
    private List<RepoDependency> repositories;
}

