package com.study.specification.pojos;

import com.study.specification.enums.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SearchFilters {
    private String attribute;
    private String value;
}
