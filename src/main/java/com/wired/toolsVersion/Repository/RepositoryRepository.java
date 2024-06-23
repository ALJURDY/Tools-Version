package com.wired.toolsVersion.Repository;

import java.util.List;
import com.wired.toolsVersion.Model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRepository extends JpaRepository<Repository, Long> {
    List<Repository> findByProjectId(Long projectId);
}

