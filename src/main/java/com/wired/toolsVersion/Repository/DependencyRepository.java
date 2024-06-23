package com.wired.toolsVersion.Repository;

import com.wired.toolsVersion.Model.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyRepository extends JpaRepository<Dependency, Long> {
}


