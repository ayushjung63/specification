package com.study.specification.service;

import com.study.specification.pojos.ProjectSpecificationPOJO;
import com.study.specification.model.Project;
import java.util.*;

public interface ProjectService {
    List<Project> getDeveloperInvolvedProject(ProjectSpecificationPOJO projectSpecificationPOJO);
}
