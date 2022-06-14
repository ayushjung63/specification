package com.study.specification.repo;

import com.study.specification.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/*
 * Need to extend JpaSpecificationExecutor alongside JpaRepository to use Specification in JPA
 *
 * */

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long>, JpaSpecificationExecutor<Project> {
}
