package com.wired.toolsVersion.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RepoPlugin {
    @EmbeddedId
    private AssociationId id = new AssociationId();

    @ManyToOne
    @MapsId("repositoryId")
    @JoinColumn(name = "id_repository")
    private Repository repository;

    @ManyToOne
    @MapsId("pluginId")
    @JoinColumn(name = "id_plugin")
    private Plugin plugin;

    @Column(name = "current_version", length = 15)
    private String currentVersion;

    @Embeddable
    @Data
    public static class AssociationId implements Serializable {
        private Long repositoryId;
        private Long pluginId;
    }
}
