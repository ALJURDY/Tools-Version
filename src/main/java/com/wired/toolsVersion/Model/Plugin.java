package com.wired.toolsVersion.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plugin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String usedVersion;
    private String currentVersion;
    private String latestRelease;

    @ManyToOne
    @JoinColumn(name = "repository_id")
    private Repository repository;
}
