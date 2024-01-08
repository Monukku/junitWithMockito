package com.spring.springbootbackend.Services;

import com.spring.springbootbackend.Model.Dependent;
import com.spring.springbootbackend.exception.DependentException;

public interface DependentService {

	public Dependent getDependentByDependentId(Long dependentId) throws DependentException;
  
	public Dependent addDependent(Dependent dependent) throws DependentException;

	public Dependent updateDependent(Dependent dependent,Long dependentId) throws DependentException;

	public void deleteDependent(Long dependentId) throws DependentException;

}
