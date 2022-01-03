
package com.neo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.StudentEntity;
import com.neo.demo.entity.UserEntity;
import com.neo.demo.jwtUtils.AuthenticationRequest;
import com.neo.demo.jwtUtils.JwtUtil;
import com.neo.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired(required = true)
	private JwtUtil jwtUtil;

	@PostMapping("/gettoken")
	public String generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid user/user not found");
		}
		return jwtUtil.generateToken(authenticationRequest.getUsername());
	}

	@PostMapping("/addstudent")
	public StudentEntity addStudent(@RequestBody StudentEntity student) {
		return service.addNewStudent(student);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAllstudents")
	public List<StudentEntity> getAllStudent() {
		return service.getAllStudnet();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("getoneStudent/{id}")
	public StudentEntity getStudentById(@PathVariable("id") int studentId) {

		return service.getByStudentId(studentId);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addadmin")
	public String addUserByAdmin(@RequestBody UserEntity user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		repository.save(user);
		return "user saved successfully...";
	}
}
