package com.wired.toolsVersion.Repository;

import java.util.Optional;

import com.wired.toolsVersion.Model.RepoDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoDependencyRepository extends JpaRepository<RepoDependency, Long> {
    Optional<RepoDependency> findCurrentVersionByRepositoryIdAndDependencyId(Long repositoryId, Long dependencyId);
}

