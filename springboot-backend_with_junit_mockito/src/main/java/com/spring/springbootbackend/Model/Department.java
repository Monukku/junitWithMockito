package com.spring.springbootbackend.Model;

import java.util.List; 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;  
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department_Table")
public class Department {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentNo")
	private Long departmentNo;
	@Column(name = "departmentName")
	private String departmentName;
	@Column(name = "departmentLocation")
	private String departmentLocation;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employeelist;
  
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Project> projectlist;

	public Department() {
		super();

	}

	public Department(Long departmentNo, String departmentName, String departmentLocation) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public Long getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Long departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public List<Employee> getEmployeeList() {
		return employeelist;
	}

	public void setEmployeeList(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public List<Project> getProject() {
		return projectlist;
	}

	public void setProject(List<Project> projectlist) {
		this.projectlist = projectlist;
	}

	@Override
	public String toString() {
		return "Department [departmentNo=" + departmentNo + ", departmentName=" + departmentName
				+ ", departmentLocation=" + departmentLocation + "]";
	}

}
