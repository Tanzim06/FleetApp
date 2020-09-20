package com.project.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fleetapp.models.State;
import com.project.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	

	public List<State> getStates(){
		return stateRepository.findAll();
	}
	

	public void save(State state) {
		stateRepository.save(state);
	}
	
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
		
	}
}
