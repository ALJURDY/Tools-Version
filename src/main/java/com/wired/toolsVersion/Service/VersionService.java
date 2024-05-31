package com.wired.toolsVersion.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class VersionService {
    public List<String> listProjects() {
        return Arrays.asList("Project1", "Project2", "Project3");
    }

    public boolean noData() {
        return false;
    }
}
