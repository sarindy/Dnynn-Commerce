package com.dnynn.productcategory;

import java.util.List;
import java.util.Map;

public interface ProductCategoryService {
	
	public List<ProductCategory> getAllProductCategory();
		
	public ProductCategory getProductCategory(int id);
	
	public void addProductCategory(ProductCategory productCategory);
	
	public void updateProductCategory(ProductCategory productCategory);
	
	public void deleteProductCategory(ProductCategory productCategory);
	
	public ProductCategory getProductCategoryByName(String name);
	
	public Map<Integer, String> getAllProductCategoryNames();

}
