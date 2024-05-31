package com.wired.toolsVersion.Repository;

import com.wired.toolsVersion.Model.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependencyRepository extends JpaRepository<Dependency, Long> {
    List<Dependency> findByRepositoryId(Long repositoryId);
}

