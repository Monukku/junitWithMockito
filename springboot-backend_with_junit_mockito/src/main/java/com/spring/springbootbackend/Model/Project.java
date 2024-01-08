package com.spring.springbootbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Project_Table")
public class Project {

	@Id
	@Column(name = "projectId")
	private Long projectId;
	@Column(name = "projectName")
	private String projectName;
	@Column(name = "projectLocation")
	private String projectLocation;

	@ManyToOne
	@JoinColumn(name = "department_No")
	private Department department;

	public Project() {
		super();

	}

	public Project(Long projectId, String projectName, String projectLocation) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectLocation = projectLocation;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setProjectLocation(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectLocation="
				+ projectLocation + "]";
	}

}
