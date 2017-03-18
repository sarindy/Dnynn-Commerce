package com.dnynn.service.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnynn.model.product.ProductTable;

@Repository
public interface ProductRepository extends CrudRepository<ProductTable, Integer> {
	
	public ProductTable findByName(String productName);
	

	

}
