package com.wired.toolsVersion.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dependency {
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

