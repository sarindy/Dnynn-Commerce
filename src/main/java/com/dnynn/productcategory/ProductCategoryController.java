package com.dnynn.productcategory;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = "/user/addProductCategory", method = RequestMethod.GET)
	public ModelAndView createNewProductCategory() {
		ModelAndView modelAndView = new ModelAndView();
		ProductCategory productCategory = new ProductCategory();
		modelAndView.addObject("productCategory", productCategory);
		modelAndView.setViewName("/user/products/addProductCategory");
		return modelAndView;
	}

	@RequestMapping(value = "/user/addProductCategory", method = RequestMethod.POST)
	public ModelAndView createNewProductCategory(@Valid ProductCategory productCategory,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/user/products/addProductCategory");
			System.out.println("has Error" + bindingResult.toString());
		} else {
			productCategoryService.addProductCategory(productCategory);;
			modelAndView.addObject("successMessage","Product Category has been registered successfully");
			modelAndView.addObject("productCategory", new ProductCategory());
			modelAndView.setViewName("/user/products/addProductCategory");

		}
		return modelAndView;
	}

}
