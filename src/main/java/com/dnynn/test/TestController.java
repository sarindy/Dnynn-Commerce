package com.dnynn.test;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dnynn.model.product.ProductTable;
import com.dnynn.service.product.ProductService;

@Controller
public class TestController {

	@Autowired
	private ProductService productService;

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
		modelAndView.addObject("productTable", productTable);
		modelAndView.setViewName("addProduct");
		return modelAndView;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid ProductTable productTable, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("addProduct");
			System.out.println("has Error" + bindingResult.toString());
		} else {
			productService.addProduct(productTable);
			modelAndView.addObject("successMessage", "Product has been registered successfully");
			modelAndView.addObject("productTable", new ProductTable());
			modelAndView.setViewName("addProduct");

		}
		return modelAndView;
	}

	

}
