package com.dnynn.service.product;

import java.util.List;

import com.dnynn.model.product.ProductTable;

public interface ProductService {
	
	public List<ProductTable> listAllProducts();
	
	public ProductTable getProductById(int id);
	
	public ProductTable getProductByName(String name);
	
	public void addProduct(ProductTable product);
	
	public void updateProduct(ProductTable product);
	
	public void deleteProduct(ProductTable product);
	
	

}
