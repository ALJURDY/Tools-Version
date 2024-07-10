package com.wired.toolsVersion.Repository;

import com.wired.toolsVersion.Model.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DependencyRepository extends JpaRepository<Dependency, Long> {
    Optional<Dependency> findByName(String name);
}


