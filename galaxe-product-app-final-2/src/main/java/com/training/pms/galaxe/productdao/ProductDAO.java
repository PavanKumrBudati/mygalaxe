package com.training.pms.galaxe.productdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.galaxe.controller.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {
	public List<Product> findByProductName(String productName);
	public List<Product> findByPriceBetween(int min, int max);
	public List<Product> findByPrice(int price);
}
