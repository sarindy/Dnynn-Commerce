package com.dnynn.product;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.productsubcategory.ProductSubCategory;
import com.dnynn.productsubcategory.ProductSubCategoryService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductSubCategoryService productSubCategoryService;

	@RequestMapping(value = "/getAllProduct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductTable>> listAllProduct() {
		List<ProductTable> products = new ArrayList<>();
		products = productService.listAllProducts();
		return new ResponseEntity<List<ProductTable>>(products, HttpStatus.OK);

	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView createNewUser() {
		ModelAndView modelAndView = new ModelAndView();
		ProductTable productTable = new ProductTable();
		List<ProductSubCategory> productSubCategoryList = new ArrayList<>();
		productSubCategoryService.getAllProductSubCategorySort().forEach(productSubCategoryList::add);
		modelAndView.addObject("productSubCategoryList", productSubCategoryList);
		modelAndView.addObject("productTable", productTable);
		modelAndView.setViewName("/product/addProduct");
		return modelAndView;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid ProductTable productTable, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/product/addProduct");
			System.out.println("has Error" + bindingResult.toString());
		} else {
			ProductSubCategory productSubCategory = new ProductSubCategory();
			productSubCategory=productSubCategoryService.getProductSubCategoryByName(productTable.getProductSubCategory().getName());
			productTable.setProductSubCategory(productSubCategory);
			productService.addProduct(productTable);
			modelAndView.addObject("successMessage", "Product has been registered successfully");
			modelAndView.addObject("productTable", new ProductTable());
			List<ProductSubCategory> productSubCategoryList = new ArrayList<>();
			productSubCategoryService.getAllProductSubCategorySort().forEach(productSubCategoryList::add);
			modelAndView.addObject("productSubCategoryList", productSubCategoryList);
			modelAndView.setViewName("/product/addProduct");

		}
		return modelAndView;
	}

	@ModelAttribute("allSubCategory")
	public List<ProductSubCategory> productSubCategories() {
		return productSubCategoryService.getAllProductSubCategory();
	}

}
