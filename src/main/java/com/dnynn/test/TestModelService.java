package com.dnynn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestModelService {
	
	@Autowired
	private TestModelRepository testModelRepo;
	
	public void addModelObj(TestModel testModel){
		testModelRepo.save(testModel);
	}
	

}
