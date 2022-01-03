package com.neo.demo.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.demo.dao.ProjectRepository;
import com.neo.demo.dao.StudentRepository;
import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.StudentEntity;
import com.neo.demo.entity.UserEntity;
import com.neo.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public StudentEntity addNewStudent(StudentEntity student) {
		return repository.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudnet() {
		return repository.findAll();
	}

	@Override
	public StudentEntity getByStudentId(int studentId) {
		return repository.findById(studentId).orElse(null);
	}

	@Override
	public UserEntity findbyUsername(String username) {
		return userRep.findByusername(username);
	}

	@Override
	public UserEntity findUserById(int id) {
		
		return userRep.findById(id).orElse(null);
	}
}
