package com.neo.demo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity

public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String firstName;
	private String lastName;
	private String gmail; 
	private long mobileNumber;
	@OneToMany(targetEntity = ProjectEntity.class,cascade = CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn(name = "sp_fk",referencedColumnName = "studentId")
	private List<ProjectEntity>project;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<ProjectEntity> getProject() {
		return project;
	}
	public void setProject(List<ProjectEntity> project) {
		this.project = project;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(int studentId, String firstName, String lastName, String gmail, long mobileNumber,
			List<ProjectEntity> project) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gmail = gmail;
		this.mobileNumber = mobileNumber;
		this.project = project;
	}
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gmail=" + gmail + ", mobileNumber=" + mobileNumber + ", project=" + project + "]";
	}
	
}
