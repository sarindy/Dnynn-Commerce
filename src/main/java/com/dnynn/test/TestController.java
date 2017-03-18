package com.dnynn.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnynn.model.product.ProductTable;
import com.dnynn.service.product.ProductService;

@RestController
public class TestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/getAllProduct",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity <List<ProductTable>> listAllProduct(){
		List<ProductTable> products = new ArrayList<>();
		products=productService.listAllProducts();
		return new ResponseEntity<List<ProductTable>>(products,HttpStatus.OK);
		
	}
	

}
