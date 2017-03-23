package com.dnynn.productsubcategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Override
	public List<ProductSubCategory> getAllProductSubCategory() {
		List<ProductSubCategory> productSubCategories = new ArrayList<>();
		productSubCategoryRepository.findAll().forEach(productSubCategories::add);
		return productSubCategories;
	}

	@Override
	public ProductSubCategory getProductSubCategoryByName(String name) {

		return productSubCategoryRepository.findByName(name);
	}

	@Override
	public ProductSubCategory getProductSubCategory(int id) {

		return productSubCategoryRepository.findOne(id);
	}

	@Override
	public void addProductSubCategory(ProductSubCategory productSubCategory) {

		productSubCategory.setLastModifiedDate(new Date());
		productSubCategoryRepository.save(productSubCategory);

	}

	@Override
	public void updateProductSubCategory(ProductSubCategory productSubCategory) {

		ProductSubCategory updated = new ProductSubCategory();
		updated = productSubCategoryRepository.findOne(productSubCategory.getId());
		if (updated != null) {
			productSubCategoryRepository.delete(productSubCategory);

			productSubCategoryRepository.save(productSubCategory);
		} else {

			productSubCategoryRepository.save(productSubCategory);
		}

	}

	@Override
	public void deleteProductSubCategory(ProductSubCategory productSubCategory) {
		productSubCategoryRepository.delete(productSubCategory);

	}

	@Override
	public List<ProductSubCategory> getAllProductSubCategorySort() {
		List<ProductSubCategory> productSubCategories = new ArrayList<>();
		productSubCategoryRepository.findAllByOrderByName().forEach(productSubCategories::add);
		return productSubCategories;
	}

}
