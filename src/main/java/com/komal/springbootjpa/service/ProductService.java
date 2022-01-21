package com.komal.springbootjpa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komal.springbootjpa.entity.Product;
import com.komal.springbootjpa.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//add data
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	//add data list
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
	//get all 
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	//get by id
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	//get by name
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	//remove data
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product removed : "+id;
	}
	//update
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);
		
	}
	
}
