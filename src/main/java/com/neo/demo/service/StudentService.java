package com.neo.demo.service;

import java.util.List;

import com.neo.demo.entity.StudentEntity;
import com.neo.demo.entity.UserEntity;


public interface StudentService {

	public StudentEntity addNewStudent(StudentEntity student);
	public List<StudentEntity> getAllStudnet();
	public StudentEntity getByStudentId(int studentId);
	
	public UserEntity findbyUsername(String username);
	
	public UserEntity findUserById(int id);
}


