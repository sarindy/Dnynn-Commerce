package com.dnynn.productsubcategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnynn.productcategory.ProductCategory;
import com.dnynn.productcategory.ProductCategoryService;

@Service
public class ProductSubCategoryServiceImpl
		implements
			ProductSubCategoryService {

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public List<ProductSubCategory> getAllProductSubCategory() {
		List<ProductSubCategory> productSubCategories = new ArrayList<>();
		productSubCategoryRepository.findAll()
				.forEach(productSubCategories::add);
		return productSubCategories;
	}

	@Override
	public ProductSubCategory getProductSubCategoryByName(String name) {

		return  productSubCategoryRepository
				.findByName(name);
	}

	@Override
	public ProductSubCategory getProductSubCategory(int id) {

		return productSubCategoryRepository.findOne(id);
	}

	@Override
	public void addProductSubCategory(ProductSubCategory productSubCategory) {
		// Get the Product Category Object
		ProductCategory productCategory = new ProductCategory();
		String productCategoryName;
		productCategoryName = productSubCategory.getProductCategory().getName();
		productCategory = productCategoryService
				.getProductCategoryByName(productCategoryName);
		// ****************************************************
		productSubCategory.setLastModifiedDate(new Date());
		productSubCategory.setProductCategory(productCategory);
		productSubCategoryRepository.save(productSubCategory);

	}

	@Override
	public void updateProductSubCategory(
			ProductSubCategory productSubCategory) {
		// Get the Product Category Object
		ProductCategory productCategory = new ProductCategory();
		String productCategoryName;
		productCategoryName = productSubCategory.getProductCategory().getName();
		productCategory = productCategoryService
				.getProductCategoryByName(productCategoryName);
		// ****************************************************
		ProductSubCategory updated = new ProductSubCategory();
		updated = productSubCategoryRepository
				.findOne(productSubCategory.getId());
		if (updated != null) {
			productSubCategoryRepository.delete(productSubCategory);
			productSubCategory.setProductCategory(productCategory);
			productSubCategoryRepository.save(productSubCategory);
		} else {
			productSubCategory.setProductCategory(productCategory);
			productSubCategoryRepository.save(productSubCategory);
		}

	}

	@Override
	public void deleteProductSubCategory(
			ProductSubCategory productSubCategory) {
		productSubCategoryRepository.delete(productSubCategory);

	}

}
