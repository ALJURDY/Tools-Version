package com.wired.toolsVersion.Repository;


import com.wired.toolsVersion.Model.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PluginRepository extends JpaRepository<Plugin, Long> {
}

