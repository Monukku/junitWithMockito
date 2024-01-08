package com.spring.springbootbackend.Services;

import com.spring.springbootbackend.Model.Project;
import com.spring.springbootbackend.exception.ProjectException;

public interface ProjectService {

//	public List<Employee> getAllByProjectgId(Long departmentNo);
//
//	public List<Employee> getAllByProjectLocation(Project projectLocation);
//
//	public List<Employee> getAllByProjectName(Project projectName);

	public Project getProjectById(Long projectId) throws ProjectException;

	public Project addProject(Project project) throws ProjectException;

	public Project updateProject(Project project, Long projectId) throws ProjectException;

	public void deleteProject(Long projectId) throws ProjectException;

}
