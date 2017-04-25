package com.dnynn.productSubCategory;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.productCategory.ProductCategory;
import com.dnynn.productCategory.ProductCategoryService;

@RestController
public class ProductSubCategoryController {

	@Autowired
	private ProductSubCategoryService productSubCategoryService;

	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = "/addProductSubCategory", method = RequestMethod.GET)
	public ModelAndView createNewProductSubCategory() {
		ModelAndView modelAndView = new ModelAndView();
		ProductSubCategory productSubCategory = new ProductSubCategory();
		List<ProductCategory> productCategories = new ArrayList<>();
		productCategoryService.getAllProductCategory().forEach(productCategories::add);
		modelAndView.addObject("productCategoryList", productCategories);
		modelAndView.addObject("productSubCategory", productSubCategory);
		modelAndView.setViewName("/productSubCategory/addProductSubCategory");
		return modelAndView;
	}

	@RequestMapping(value = "/addProductSubCategory", method = RequestMethod.POST)
	public ModelAndView createNewProductCategory(@Valid ProductSubCategory productSubCategory,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/productSubCategory/addProductSubCategory");

		} else {

			ProductCategory productCategory = new ProductCategory();
			productCategory=productCategoryService.getProductCategoryByName(productSubCategory.getProductCategory().getName());
			System.out.println(productCategory.getName());
			productSubCategory.setProductCategory(productCategory);
			productSubCategoryService.addProductSubCategory(productSubCategory);
			modelAndView.addObject("successMessage", "Product Sub Category has been registered successfully");
			List<ProductCategory> productCategories = new ArrayList<>();
			productCategoryService.getAllProductCategory().forEach(productCategories::add);
			modelAndView.addObject("productCategoryList", productCategories);
			modelAndView.addObject("productSubCategory", new ProductSubCategory());
			modelAndView.setViewName("/productSubCategory/addProductSubCategory");
		

		}
		return modelAndView;
	}

	/*
	 * private List<ProductCategory> populateProductCategory(){
	 * List<ProductCategory> productCategories = new ArrayList<>();
	 * 
	 * return null;
	 * 
	 * }
	 */

}
