package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neo.demo.entity.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {


}
