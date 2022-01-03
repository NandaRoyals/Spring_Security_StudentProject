package com.neo.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String role;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleEntity [role_id=" + role_id + ", role=" + role + "]";
	}
	public RoleEntity(int role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

