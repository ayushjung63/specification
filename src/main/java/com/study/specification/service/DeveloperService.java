package com.study.specification.service;

import com.study.specification.model.Developer;
import com.study.specification.pojos.DeveloperSpecificationPOJO;
import com.study.specification.pojos.SearchSpecificationPojo;

import java.util.*;

public interface DeveloperService {

    List<Developer> getDevelopersList(DeveloperSpecificationPOJO developerSpecificationPOJO);

    List<Developer> findDeveloperByDepartment(String department);

    List<Developer> findDeveloperByDepartmentAndType(String department,String type);

    List<Object[]> findDeveloperGroupDepartment();
}
