package com.dnynn.test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestModelService {

	@Autowired
	private TestModelRepository testModelRepo;
	private SecureRandom random = new SecureRandom();


	public void addModelObj() {
		
		for (int i=1;i<=5000;i++){
			
			testModelRepo.save(new TestModel(new BigInteger(130, random).toString(32)));
			

		}
				
	}

	public List<TestModel> getAllModels() {
		List<TestModel> models = new ArrayList<>();

		testModelRepo.findAll().forEach(models::add);

		return models;

	}

}
