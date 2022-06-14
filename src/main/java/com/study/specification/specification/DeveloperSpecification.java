package com.study.specification.specification;

import com.study.specification.enums.Department;
import com.study.specification.model.Address;
import com.study.specification.model.Developer;
import com.study.specification.pojos.DeveloperSpecificationPOJO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;

/*
* Our Custom Specification Class implements Specification interface
*
* */

public class DeveloperSpecification implements Specification<Developer> {

    private final DeveloperSpecificationPOJO developerSpecificationPOJO;

    public DeveloperSpecification(DeveloperSpecificationPOJO developerSpecificationPOJO) {
        this.developerSpecificationPOJO = developerSpecificationPOJO;
    }

    @Override
    public Predicate toPredicate(Root<Developer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        Path<String> type = root.get("type");
        Path<String> department = root.get("department");

        if (developerSpecificationPOJO.isConditional()) {
            if (developerSpecificationPOJO.getType() != null && developerSpecificationPOJO.getDepartment() != null) {

                Predicate equal = criteriaBuilder.equal(type, developerSpecificationPOJO.getType());
                Predicate equal2 = criteriaBuilder.equal(department, developerSpecificationPOJO.getDepartment());
                Predicate finalPredicate = criteriaBuilder.or(equal, equal2);
                predicateList.add(finalPredicate);
            }
        } else {
            if (developerSpecificationPOJO.getName() != null) {
                Path<String> name = root.get("name");
                predicateList.add(criteriaBuilder.like(name, "%" + developerSpecificationPOJO.getName() + "%"));
            }

            if (developerSpecificationPOJO.getDepartment() != null) {
                predicateList.add(criteriaBuilder.equal(department, developerSpecificationPOJO.getDepartment()));
            }

            if (developerSpecificationPOJO.getType() != null) {
                predicateList.add(criteriaBuilder.equal(type, developerSpecificationPOJO.getType()));
            }

            if (developerSpecificationPOJO.getCity() != null) {
                Path<String> address = root.get("address").get("city");
                predicateList.add(address.in(developerSpecificationPOJO.getCity()));
            }
        }

       return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }


    public static Specification<Developer> fromDepartment(Department department){
        return new Specification<Developer>() {
            @Override
            public Predicate toPredicate(Root<Developer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("department"),department);
            }
        };
    }


}
