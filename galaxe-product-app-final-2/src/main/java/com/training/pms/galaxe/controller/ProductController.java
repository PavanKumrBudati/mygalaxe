package com.training.pms.galaxe.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.galaxe.service.ProductService;

@RestController
@RequestMapping("product")
// @CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	ProductService productService;

	String message;

	@PostMapping // http://localhost:9090/product/ - POST - BODY
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity;
		String message = productService.saveProduct(product);
		if (message.equals("Product saved successfully. You are a genious."))
			responseEntity = new ResponseEntity<String>(message,
					HttpStatus.CREATED);
		else
			responseEntity = new ResponseEntity<String>(message,
					HttpStatus.NOT_ACCEPTABLE);
		return responseEntity;
	}

	@GetMapping // http://localhost:9090/product
	public ResponseEntity<List<Product>> getProducts() {
		ResponseEntity<List<Product>> responseEntity = null;
		List<Product> products = productService.getProduct();
		if (products.isEmpty()) {
			responseEntity = new ResponseEntity<List<Product>>(products,
					HttpStatus.NO_CONTENT); // 204
		} else {
			responseEntity = new ResponseEntity<List<Product>>(products,
					HttpStatus.OK); // 200
		}

		return responseEntity;
	}

	@GetMapping("{productId}") // http://localhost:9090/product/198
	public ResponseEntity<Product> getProduct(
			@PathVariable("productId") Integer productId) {
		ResponseEntity<Product> responseEntity = null;
		Product products = productService.getProduct(productId);
		if (!productService.isProductExists(productId)) {
			responseEntity = new ResponseEntity<Product>(products,
					HttpStatus.NO_CONTENT); // 204
		} else {
			responseEntity = new ResponseEntity<Product>(products,
					HttpStatus.OK); // 204
		}
		return responseEntity;
	}

	@DeleteMapping("{productId}") // http://localhost:9090/product/198 - DELETE
	public String deleteProduct(@PathVariable("productId") Integer productId) {
		return "Deleting a single products";
	}

	@PutMapping // http://localhost:9090/product/ - PUT - BODY
	public String updateProduct(@RequestBody Product product) {
		return "updating a single products  ::  " + product;
	}
}
