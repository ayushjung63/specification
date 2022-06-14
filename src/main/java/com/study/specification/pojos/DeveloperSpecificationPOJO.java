package com.study.specification.pojos;

import com.study.specification.enums.Department;
import com.study.specification.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperSpecificationPOJO {

    private String name;

    private Department department;

    private Type type;

    private String city;

    private boolean conditional;
}
