package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PODModel;



public interface PODRepository extends CrudRepository<PODModel, Integer>
{
	
	public PODModel findByUsernameAndPassword(String username, String password);

}
