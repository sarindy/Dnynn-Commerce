package com.dnynn.test;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.productcategory.ProductCategory;
import com.dnynn.productcategory.ProductCategoryServiceImpl;

@RestController
public class TestModelController {

	@Autowired
	private TestModelService testModelService;

	@RequestMapping(value = "/testModel", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		TestModel testModel = new TestModel();
		modelAndView.addObject("testModel", testModel);
		modelAndView.setViewName("testModel");
		return modelAndView;
	}

	@RequestMapping(value = "/testModel", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid TestModel testModel, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("testModel");

		} else {
			testModelService.addModelObj();
			modelAndView.addObject("successMessage", "Registered successfully");
			modelAndView.addObject("testModel", new TestModel());
			modelAndView.setViewName("testModel");

		}
		return modelAndView;
	}

	@Autowired
	private ProductCategoryServiceImpl productCatSer;

	@RequestMapping(value = "/testMap", method = RequestMethod.GET)
	public ModelAndView Test() {
		ModelAndView modelAndView = new ModelAndView();
		ProductCategory p = new ProductCategory();
		List<ProductCategory> categories = new ArrayList<>();
		productCatSer.getAllProductCategory().forEach(categories::add);
		modelAndView.addObject("category", categories);
		modelAndView.addObject("p", p);
		modelAndView.setViewName("testModel");
		return modelAndView;
	}
	
	@RequestMapping(value="/123456")
	public ResponseEntity<?> getAllModel(){
		testModelService.addModelObj();
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		//
	}
	
	@RequestMapping(value="/999")
	public ResponseEntity<?> getAllModels(){
		List<TestModel> models = new ArrayList<>();
		testModelService.getAllModels().forEach(models::add);
		return new ResponseEntity<List<TestModel>>(models,HttpStatus.OK);
		//
	}

}
