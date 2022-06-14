package com.study.specification.controller;

import com.study.specification.model.Developer;
import com.study.specification.model.Student;
import com.study.specification.pojos.SearchSpecificationPojo;
import com.study.specification.repo.StudentRepo;
import com.study.specification.specification.GenericSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping("/generic")
    public ResponseEntity getDevelopersBySearchFilter(@RequestBody SearchSpecificationPojo searchSpecificationPojo){
        List<Student> studentList = studentRepo.findAll(new GenericSpecification(searchSpecificationPojo));
        return ResponseEntity.ok(studentList);
    }

}
