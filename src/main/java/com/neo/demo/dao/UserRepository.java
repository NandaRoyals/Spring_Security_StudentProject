package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByusername(String username);
}
