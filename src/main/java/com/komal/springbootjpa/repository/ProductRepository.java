package com.komal.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komal.springbootjpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
