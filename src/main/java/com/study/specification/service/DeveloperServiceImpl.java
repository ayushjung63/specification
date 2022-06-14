package com.study.specification.service;

import com.study.specification.enums.Department;
import com.study.specification.enums.Type;
import com.study.specification.model.Developer;
import com.study.specification.pojos.DeveloperSpecificationPOJO;
import com.study.specification.pojos.SearchSpecificationPojo;
import com.study.specification.repo.CustomDeveloperRepo;
import com.study.specification.repo.DeveloperRepo;
import com.study.specification.specification.DeveloperSpecification;
import com.study.specification.specification.DeveloperSpecificationQueries;
import com.study.specification.specification.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final  DeveloperRepo developerRepo;

    private final CustomDeveloperRepo customDeveloperRepo;

    public DeveloperServiceImpl(DeveloperRepo developerRepo, CustomDeveloperRepo customDeveloperRepo) {
        this.developerRepo = developerRepo;
        this.customDeveloperRepo = customDeveloperRepo;
    }

    @Override
    public List<Developer> findDeveloperByDepartment(String department) {
        /*Specification<Developer> developerSpecification = DeveloperSpecificationQueries.fromDepartment(Department.valueOf(department));
        List<Developer> all = developerRepo.findAll(developerSpecification);*/
        List<Developer> developerByDepartment = customDeveloperRepo.findDeveloperByDepartment(Department.valueOf(department));
        return developerByDepartment;
    }

    @Override
    public List<Object[]> findDeveloperGroupDepartment() {
        List<Object[]> developerGroupByDepartment = customDeveloperRepo.findDeveloperGroupByDepartment();
        return developerGroupByDepartment;

    }

    @Override
    public List<Developer> getDevelopersList(DeveloperSpecificationPOJO developerSpecificationPOJO) {
        List<Developer> all = developerRepo.findAll(new DeveloperSpecification(developerSpecificationPOJO));
        return all;
    }

    @Override
    public List<Developer> findDeveloperByDepartmentAndType(String department, String type) {
        Specification<Developer> fromDepartment = DeveloperSpecificationQueries.fromDepartment(Department.valueOf(department));
        Specification<Developer> fromType = DeveloperSpecificationQueries.fromType(Type.valueOf(type));
        List<Developer> all = developerRepo.findAll(Specification.where(fromDepartment).and(fromType));

        List<Developer> all1 = developerRepo.findAll(Specification.where(fromDepartment).or(fromType));

        List<Developer> all2 = developerRepo.findAll(Specification.where(fromDepartment).and(Specification.not(fromType)));

        return all;
    }

}
