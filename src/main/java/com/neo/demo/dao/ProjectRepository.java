package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

}
