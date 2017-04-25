package com.dnynn.productSubCategory;

import java.util.List;

public interface ProductSubCategoryService {

	public List<ProductSubCategory> getAllProductSubCategory();

	public ProductSubCategory getProductSubCategoryByName(String name);

	public ProductSubCategory getProductSubCategory(int id);

	public void addProductSubCategory(ProductSubCategory productSubCategory);

	public void updateProductSubCategory(ProductSubCategory productSubCategory);

	public void deleteProductSubCategory(ProductSubCategory productSubCategory);

	public List<ProductSubCategory> getAllProductSubCategorySort();

}
