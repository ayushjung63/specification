package com.study.specification.specification;

import com.study.specification.enums.Department;
import com.study.specification.enums.Type;
import com.study.specification.model.Developer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

public class DeveloperSpecificationQueries {

    public static Specification<Developer> fromDepartment(Department department){
        return (root, query, criteriaBuilder) -> {
            Path<String> department1 = root.get("department");
             return criteriaBuilder.equal(department1,department);
        };
    }

    public static Specification<Developer> fromType(Type type){
        return (root, query, criteriaBuilder) -> {
            Path<String> type1 = root.get("type");
            return criteriaBuilder.equal(type1,type);
        };
    }
}
