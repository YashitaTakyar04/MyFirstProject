package com.takyar.api.apiDemo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired  
	private IProductService productService;  
	
	@GetMapping(value = "/product")
	public List<Product> getProduct() {
		//finds all the products  
		List<Product> products = productService.findAll();  
		//returns the product list  
		return products;  
		
	}
	
	@GetMapping(value = "/quote")
	
	
	
	
	public Object  getQuote() {
		Resource resource = new ClassPathResource("/static/json/quote.json");
		try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;  
		
	}
	
	@GetMapping(value = "/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		//finds all the products  
		Product product = productService.findById(id);
		//returns the product list  
		return product;  
		
	}
	
	@PostMapping("/product")
	public Product newProduct(@RequestBody Product product) {
		//finds all the products  
		productService.newProduct(product);
		//returns the product list  
		return productService.findById(product.getId());  
		
	}

}
