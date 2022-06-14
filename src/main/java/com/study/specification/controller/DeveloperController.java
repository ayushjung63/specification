package com.study.specification.controller;

import com.study.specification.model.Developer;
import com.study.specification.pojos.DeveloperSpecificationPOJO;
import com.study.specification.pojos.SearchSpecificationPojo;
import com.study.specification.repo.DeveloperRepo;
import com.study.specification.service.DeveloperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService  developerService;

    public DeveloperController(DeveloperRepo developerRepo, DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("department/{department}")
    public ResponseEntity getDevelopersByDepartment(@PathVariable("department") String department){
        List<Developer> developerList = developerService.findDeveloperByDepartment(department);
        return ResponseEntity.ok(developerList);
    }

    @GetMapping("group-by-department")
    public ResponseEntity getDevelopersGroupByDepartment(){
        return ResponseEntity.ok( developerService.findDeveloperGroupDepartment());
    }

    @PostMapping
    public ResponseEntity getDevelopers(@RequestBody DeveloperSpecificationPOJO developerSpecificationPOJO){
        List<Developer> developerList = developerService.getDevelopersList(developerSpecificationPOJO);
        return ResponseEntity.ok(developerList);
    }

    @GetMapping("department/{department}/type/{type}")
    public ResponseEntity getDevelopersByDepartmentAndType(@PathVariable("department") String department,@PathVariable("type") String type){
        List<Developer> developerList = developerService.findDeveloperByDepartmentAndType(department,type);
        return ResponseEntity.ok(developerList);
    }
}
