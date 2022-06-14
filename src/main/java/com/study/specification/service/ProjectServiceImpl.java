
package com.study.specification.service;

import com.study.specification.pojos.ProjectSpecificationPOJO;
import com.study.specification.model.Project;
import com.study.specification.repo.ProjectRepo;
import com.study.specification.specification.ProjectSpecification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProjectServiceImpl  implements ProjectService{
    private final ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getDeveloperInvolvedProject(ProjectSpecificationPOJO projectSpecificationPOJO) {
        List<Project> all = projectRepo.findAll(new ProjectSpecification(projectSpecificationPOJO));
        if (all!=null){
            return all;
        }else{
            return Collections.EMPTY_LIST;
        }
    }
}
