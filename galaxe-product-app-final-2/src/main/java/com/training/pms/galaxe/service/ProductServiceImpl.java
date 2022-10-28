package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.controller.Product;
import com.training.pms.galaxe.productdao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		String message = null;
		if (product.getPrice() < 0 || product.getQuantityOnHand() < 0) {
			message = "Product with negative price or quantity cannot be saved";
		} else {
			message = "Product saved successfully";
			productDAO.save(product);
		}
		return message;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		String message = null;
		if (product.getPrice() < 0 || product.getQuantityOnHand() < 0) {
			message = "Product with negative price or quantity cannot be saved";
		} else {
			message = "Product updated successfully";
			productDAO.save(product);
		}
		return message;
	}

	@Override
	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productDAO.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = productDAO.findById(productId);
		return product.get();
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return (List<Product>) productDAO.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = productDAO.findById(productId);
		return product.isPresent();
	}

	@Override
	public List<Product> searchProductByName(String productName) {
		return null;
	}

	@Override
	public List<Product> getProduct(String productName) {
		return productDAO.findByProductName(productName);
	}

	@Override
	public List<Product> getProduct(int min, int max) {
		return productDAO.findByPriceBetween(min, max);
	}

	@Override
	public String checkProductInventory(int productId, int quantityRequired) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByPrice(int price) {
		// TODO Auto-generated method stub
		return productDAO.findByPrice(price);
	}

}

//
//
// import java.util.Optional;
//
//
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
//
//
//
// import com.productappfinal.dao.ProductDao;
// import com.productappfinal.model.Product;
//
//
//
//
// @Service
// public class ProductServiceImpl implements ProductService {
//
// @Autowired
// ProductDao productDAO;
//
//
//
// public ProductServiceImpl() {
// // TODO Auto-generated constructor stub
// }
//
//
//
// @Override
// public String saveProduct(Product product) {
// // TODO Auto-generated method stub
// String message=null;
// if(product.getPrice()<0 || product.getQuantityOnHand()<0) {
// message="Product with negative price or quantity cannot be saved";
// }
// else {
// message="Product saved successfully";
// productDAO.save(product);
// }
// return message;
// }
//
//
//
// @Override
// public String updateProduct(Product product) {
// // TODO Auto-generated method stub
// String message=null;
// if(product.getPrice()<0 || product.getQuantityOnHand()<0) {
// message="Product with negative price or quantity cannot be saved";
// }
// else {
// message="Product updated successfully";
// productDAO.save(product);
// }
// return message;
// }
//
//
//
// @Override
// public String deleteProduct(int productId) {
// // TODO Auto-generated method stub
// productDAO.deleteById(productId);
// return "Product deleted successfully";
// }
//
//
//
// @Override
// public Product getProduct(int productId) {
// // TODO Auto-generated method stub
// Optional<Product> product=productDAO.findById(productId);
// return product.get();
// }
//
//
//
// @Override
// public List<Product> getProduct() {
// // TODO Auto-generated method stub
// return (List<Product>) productDAO.findAll();
// }
//
//
//
// @Override
// public boolean isProductExists(int productId) {
// // TODO Auto-generated method stub
// Optional<Product> product=productDAO.findById(productId);
// return product.isPresent();
// }
//
//
//
// @Override
// public List<Product> searchProductByName(String productName) {
// // TODO Auto-generated method stub
// return null;
// }
// @Override
// public List<Product> getProduct(String productName) {
// return productDAO.findByProductName(productName);
// }
//
//
//
//
//
// @Override
// public List<Product> getProduct(int min, int max) {
// // TODO Auto-generated method stub
// return productDAO.findByPriceBetween(min, max);
// }
//
//
//
// @Override
// public String checkProductInventory(int productId, int quantityRequired) {
// // TODO Auto-generated method stub
// return null;
// }
//
//
//
// @Override
// public List<Product> getProductByPrice(int price) {
// // TODO Auto-generated method stub
// return productDAO.findByPrice(price);
// }
//
//
//
//
// }