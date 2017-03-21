package com.dnynn.productsubcategory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Integer> {
	
	public List<ProductSubCategory> findByName(String name);

}
