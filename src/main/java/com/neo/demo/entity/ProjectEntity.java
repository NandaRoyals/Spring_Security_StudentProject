package com.neo.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String projectName;
	private double projectDuration;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(double projectDuration) {
		this.projectDuration = projectDuration;
	}
	@Override
	public String toString() {
		return "ProjectEntity [projectId=" + projectId + ", projectName=" + projectName + ", projectDuration="
				+ projectDuration + "]";
	}
	public ProjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectEntity(int projectId, String projectName, double projectDuration) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDuration = projectDuration;
	}
	
	
	
	

	
}
