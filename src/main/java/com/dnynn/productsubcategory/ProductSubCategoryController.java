package com.dnynn.productsubcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.productcategory.ProductCategory;
import com.dnynn.productcategory.ProductCategoryService;

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
		modelAndView.addObject("productCategoryObj", productCategoryService.getAllProductCategory());
		productSubCategory.setProductCategory((ProductCategory) productCategoryService.getAllProductCategory());
		modelAndView.addObject("productSubCategory", productSubCategory);
		modelAndView.setViewName("/productSubCategory/addProductSubCategory");
		return modelAndView;
	}
	
	public List<ProductCategory> getCategory(){
		return productCategoryService.getAllProductCategory();
	}

	/*@RequestMapping(value = "/addProductSubCategory", method = RequestMethod.POST)
	public ModelAndView createNewProductCategory(@Valid ProductCategory productCategory,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addProduct");
			System.out.println("has Error" + bindingResult.toString());
		} else {
			productCategoryService.addProductCategory(productCategory);;
			modelAndView.addObject("successMessage","Product Category has been registered successfully");
			modelAndView.addObject("productCategory", new ProductCategory());
			modelAndView.setViewName("/productCategory/addProductCategory");

		}
		return modelAndView;
	}*/
	
	/*private List<ProductCategory> populateProductCategory(){
		List<ProductCategory> productCategories = new ArrayList<>();
		
		return null;
		
	}*/

}
