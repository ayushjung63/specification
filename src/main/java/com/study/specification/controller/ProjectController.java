package com.study.specification.controller;

import com.study.specification.pojos.ProjectSpecificationPOJO;
import com.study.specification.model.Project;
import com.study.specification.service.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public List<Project> getProjectByDeveloperName(@RequestBody ProjectSpecificationPOJO projectSpecificationPOJO){
        List<Project> all = projectService.getDeveloperInvolvedProject(projectSpecificationPOJO);
        return all;
    }
}
