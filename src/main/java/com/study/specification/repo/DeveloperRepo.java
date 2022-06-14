package com.study.specification.repo;

import com.study.specification.model.Developer;
import org.springframework.stereotype.Repository;

/*
* Need to extend JpaSpecificationExecutor alongside JpaRepository to use Specification in JPA
* */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer,Long>,
        JpaSpecificationExecutor<Developer> {

}
