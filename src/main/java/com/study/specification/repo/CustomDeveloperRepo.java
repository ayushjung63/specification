package com.study.specification.repo;

import com.study.specification.enums.Department;
import com.study.specification.model.Developer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;

@Repository
public class CustomDeveloperRepo {

    private final EntityManager entityManager;

    public CustomDeveloperRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Developer> findDeveloperByDepartment(Department department){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Developer> criteriaQuery=criteriaBuilder.createQuery(Developer.class);

        Root<Developer> root = criteriaQuery.from(Developer.class);
        Predicate departmentPredicate = criteriaBuilder.equal(root.get("department"), department);
        criteriaQuery.where(departmentPredicate);


        TypedQuery<Developer> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    public List<Object[]> findDeveloperGroupByDepartment(){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery=criteriaBuilder.createQuery(Object[].class);

        Root<Developer> root = criteriaQuery.from(Developer.class);
        Path<String> department = root.get("department");
        criteriaQuery.multiselect(department,criteriaBuilder.count(root)).groupBy(department);

        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);

        List<Object[]> resultList = query.getResultList();
        return resultList;

    }
}
