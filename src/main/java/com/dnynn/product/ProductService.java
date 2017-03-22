package com.dnynn.product;

import java.util.List;

public interface ProductService {
	
	public List<ProductTable> listAllProducts();
	
	public ProductTable getProductById(int id);
	
	public ProductTable getProductByName(String name);
	
	public void addProduct(ProductTable product);
	
	public void updateProduct(ProductTable product);
	
	public void deleteProduct(ProductTable product);
	
	

}
