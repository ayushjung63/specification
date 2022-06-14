package com.study.specification.specification;

import com.study.specification.model.Student;
import com.study.specification.pojos.SearchFilters;
import com.study.specification.pojos.SearchSpecificationPojo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class GenericSpecification implements Specification<Student> {
    private final SearchSpecificationPojo searchSpecificationPojo;

    public GenericSpecification(SearchSpecificationPojo searchSpecificationPojo) {
        this.searchSpecificationPojo = searchSpecificationPojo;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();

        if (searchSpecificationPojo!=null && searchSpecificationPojo.getFiltersList()!=null){
            List<SearchFilters> filtersList = searchSpecificationPojo.getFiltersList();
            for (SearchFilters filter:filtersList){
                String property = filter.getAttribute();
                Path expression = root.get(property);
                Predicate equal = criteriaBuilder.equal(expression, filter.getValue());
                predicateList.add(equal);
            }
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }

}
