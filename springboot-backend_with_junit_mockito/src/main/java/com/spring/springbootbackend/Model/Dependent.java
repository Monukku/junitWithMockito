package com.spring.springbootbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dependent_Table")
public class Dependent {

	@Id
	@Column(name = "id")
	private Long dependentId;
	@Column(name = "dependentName")
	private String dependentName;
	@Column(name = "dependentGender")
	private String dependentGender;
	@Column(name = "dependentRelationship")
	private String dependentRelationship;

	public Dependent() {
		super();

	}

	public Dependent(Long dependentId, String dependentName, String dependentGender, String dependentRelationship) {
		super();
		this.dependentId = dependentId;
		this.dependentName = dependentName;
		this.dependentGender = dependentGender;
		this.dependentRelationship = dependentRelationship;
	}

	public Long getDependentId() {
		return dependentId;
	}

	public void setDependentId(Long dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getDependentGender() {
		return dependentGender;
	}

	public void setDependentGender(String dependentGender) {
		this.dependentGender = dependentGender;
	}

	public String getDependentRelationship() {
		return dependentRelationship;
	}

	public void setDependentRelationship(String dependentRelationship) {
		this.dependentRelationship = dependentRelationship;
	}

	@Override
	public String toString() {
		return "Dependent [dependentId=" + dependentId+ ", dependentName=" + dependentName + ", dependentGender=" + dependentGender
				+ ", dependentRelationship=" + dependentRelationship + "]";
	}

}
