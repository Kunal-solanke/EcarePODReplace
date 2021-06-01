package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.PODModel;
import com.example.demo.repository.PODRepository;


@Component
public class PODService {

	@Autowired
	private  PODRepository podRepository;



	public PODService(PODRepository podRepository) {
		this.podRepository=podRepository;

	}

	public void saveMyUser(PODModel model ) {
		podRepository.save(model);
	}

	public List<PODModel> showAllUsers()
	{
		List<PODModel> users = new ArrayList<PODModel>();
		for(PODModel user : podRepository.findAll()) {
			users.add(user);

		}
		return users;
	}

	public void deleteMyUser(int id) {
		podRepository.deleteById(id);;
	}

	public PODModel editUser(int id) {
		return podRepository.findById(id).orElse(null);


	}

	public PODModel findByUsernameAndPassword(String username, String password)
	{
		return podRepository.findByUsernameAndPassword(username, password);

	}

}
