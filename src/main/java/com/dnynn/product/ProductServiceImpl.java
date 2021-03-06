package com.dnynn.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	

	@Override
	public List<ProductTable> listAllProducts() {
		List<ProductTable> productList = new ArrayList<>();
		productRepo.findAll().forEach(productList::add);
		return productList;
	}

	@Override
	public ProductTable getProductById(int id) {
		return productRepo.findOne(id);
	}

	@Override
	public ProductTable getProductByName(String productName) {
		return productRepo.findByName(productName);
	}

	@Override
	public void addProduct(ProductTable product) {
		product.setLastModifiedDate( new Date());
		productRepo.save(product);
	}

	@Override
	public void updateProduct(ProductTable product) {
		// Looking for existing product first then delete then Save new
		ProductTable updateProduct = productRepo
				.findOne(product.getProductId());
		if (updateProduct != null) {
			productRepo.delete(updateProduct);
			Date currentDate = new Date();
			product.setLastModifiedDate( currentDate);
			productRepo.save(product);
		} else {
			Date currentDate = new Date();
			product.setLastModifiedDate( currentDate);
			productRepo.delete(product);
			productRepo.save(product);
		}

	}

	@Override
	public void deleteProduct(ProductTable product) {
		productRepo.delete(product);

	}

}
