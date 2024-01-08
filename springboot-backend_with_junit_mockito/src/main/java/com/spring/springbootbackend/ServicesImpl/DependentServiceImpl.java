package com.spring.springbootbackend.ServicesImpl;

import org.springframework.stereotype.Service;
import com.spring.springbootbackend.Model.Dependent;
import com.spring.springbootbackend.Repository.DependentRepository;
import com.spring.springbootbackend.Services.DependentService;
import com.spring.springbootbackend.exception.DependentException;

@Service
public class DependentServiceImpl implements DependentService {

	private final DependentRepository dependentRepository;

	public DependentServiceImpl(DependentRepository dependentRepository) {
		super();
		this.dependentRepository = dependentRepository;
	}

	@Override
	public Dependent getDependentByDependentId(Long dependentId) throws DependentException{

		Dependent dependent = dependentRepository.findById(dependentId).orElseThrow(
				() -> new DependentException("Dependent with given dependentId " + dependentId + " doesnot exist"));

		return dependent;
	}

	@Override
	public Dependent addDependent(Dependent dependent) {
      
		return dependentRepository.saveAndFlush(dependent);
	}

	@Override
	public Dependent updateDependent(Dependent dependent,Long dependentId)  throws DependentException{
		
		Dependent existingdepen= dependentRepository.findById(dependentId).orElseThrow(() -> new DependentException("Dependent with given dependentId " + dependentId + " doesnot exist"));
		
		existingdepen.setDependentName(dependent.getDependentName());
		existingdepen.setDependentGender(dependent.getDependentGender());
		existingdepen.setDependentRelationship(dependent.getDependentRelationship());
		existingdepen.setDependentId(dependent.getDependentId());
		
		Dependent updatedDependent=dependentRepository.saveAndFlush(existingdepen);
		
		return updatedDependent;
	}

	@Override
	public void deleteDependent(Long dependentId)throws DependentException {
		
		try {
			dependentRepository.deleteById(dependentId);
		} catch (Exception e) {
			throw new DependentException("Dependent with given dependentId " + dependentId + " doesnot exist");
		}

	}

}
