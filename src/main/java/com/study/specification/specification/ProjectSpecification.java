package com.study.specification.specification;

import com.study.specification.pojos.ProjectSpecificationPOJO;
import com.study.specification.model.Project;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectSpecification implements Specification<Project> {
    private final ProjectSpecificationPOJO projectSpecificationPOJO;

    public ProjectSpecification(ProjectSpecificationPOJO projectSpecificationPOJO) {
        this.projectSpecificationPOJO = projectSpecificationPOJO;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();

        if (projectSpecificationPOJO.getDeveloperId()!=null){
            Path<Long> developersId= root.join("developerInvolved").get("id");
            predicateList.add(developersId.in(projectSpecificationPOJO.getDeveloperId()));
        }
        if (projectSpecificationPOJO.getTitle()!=null){
            Predicate title = criteriaBuilder.equal(root.get("title"), projectSpecificationPOJO.getTitle());
            predicateList.add(title);
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
