package com.dnynn.productsubcategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Integer> {
	
	public ProductSubCategory findByName(String name);

}
