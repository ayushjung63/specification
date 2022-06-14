package com.study.specification.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",allocationSize = 1,sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String faculty;

}
