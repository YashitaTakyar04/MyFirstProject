package com.takyar.api.apiDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	
	Map<Long, Product> products = new HashMap<Long, Product>();
	
	public ProductService () {
		products.put(100L, new Product(100L, "Mobile", "CLK98123", 9000.00, 6));
		products.put(101L, new Product(101L, "Smart TV", "LGST09167", 60000.00, 3));
		products.put(102L, new Product(102L, "Washing Machine", "38753BK9", 9000.00, 7));
		products.put(103L, new Product(103L, "Laptop", "LHP29OCP", 24000.00, 1));
		products.put(104L, new Product(104L, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.put(105L, new Product(105L, "Refrigerator ", "12WP9087", 10000.00, 4));
	}

	@Override
	public List<Product> findAll() {
		List<Product> results = new ArrayList<Product>();
		Set<Long> ids = products.keySet();
		for (Long long1 : ids) {
			results.add(products.get(long1));
		}
		return results;
	}

	@Override
	public Product findById(Long id) {
		return products.get(id);
	}

	@Override
	public void newProduct(Product product) {
		if(products.containsKey(product.getId())) {
			throw new RuntimeException("Id "+product.getId()+ " already Exist");
		}
		products.put(product.getId(), product);
	}
}
