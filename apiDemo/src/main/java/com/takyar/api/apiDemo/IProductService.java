package com.takyar.api.apiDemo;

import java.util.List;

public interface IProductService {
	
	List<Product> findAll(); 
	
	Product findById(Long id);
	
	void newProduct(Product product);

}
