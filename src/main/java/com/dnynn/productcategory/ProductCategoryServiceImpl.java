package com.dnynn.productcategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> getAllProductCategory() {
		List<ProductCategory> prooductCategories = new ArrayList<>();
		productCategoryRepository.findAll().forEach(prooductCategories::add);
		return prooductCategories;
	}

	@Override
	public ProductCategory getProductCategory(int id) {
		return productCategoryRepository.findOne(id);
	}

	@Override
	public void addProductCategory(ProductCategory productCategory) {
		productCategory.setLastModifiefDate(new Date());
		productCategoryRepository.save(productCategory);

	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {

		ProductCategory updated = new ProductCategory();
		updated = productCategoryRepository.findOne(productCategory.getId());
		if (updated != null){
			productCategoryRepository.delete(productCategory.getId());
			productCategory.setLastModifiefDate(new Date());
			productCategoryRepository.save(productCategory);
		}else{
			productCategory.setLastModifiefDate(new Date());
			productCategoryRepository.save(productCategory);
		}
		

	}

	@Override
	public void deleteProductCategory(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);

	}

	@Override
	public ProductCategory getProductCategoryByName(String name) {
	
		return (ProductCategory) productCategoryRepository.findByName(name);
	}

}
