package com.neo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

}
