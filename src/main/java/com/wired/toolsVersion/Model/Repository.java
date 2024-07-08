package com.wired.toolsVersion.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "repository")
public class Repository {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 10)
    private String percentage;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToMany
    @JoinTable(
            name = "RepoDependency",
            joinColumns = @JoinColumn(name = "id_repository"),
            inverseJoinColumns = @JoinColumn(name = "id_dependency")
    )
    private List<Dependency> dependencies;

    @ManyToMany
    @JoinTable(
            name = "RepoPlugin",
            joinColumns = @JoinColumn(name = "id_repository"),
            inverseJoinColumns = @JoinColumn(name = "id_plugin")
    )
    private List<Plugin> plugins;
}
