package com.ngsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngsb.dto.ProductDto;
import com.ngsb.entity.Product;
import com.ngsb.exeption.ProductNotFoundException;
import com.ngsb.repo.ProductRepo;
import com.ngsb.service.IProductService;
import com.ngsb.utility.AppUtil;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public String saveProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProdName(productDto.getProdName());
		product.setProdQty(productDto.getProdQty());
		product.setProdPrice(productDto.getProdPrice());
		product.setIsProdAvailable(productDto.getIsProdAvailable());
		product.setCreatedBy("Admin");
		Product savedProduct = repo.save(product);
		return new StringBuilder().append("Product Saved Successfully With Id : ").append(savedProduct.getProdId()).toString();
	}

	@Override
	public List<Product> getAllProduct() {
		return repo.findAll();
	}
	
	@Override
	public Product getProductById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException(new StringBuilder().append("Sorry! Product with id ").append(id).append(" not found!").toString()));
	}
	
	@Override
	public String deleteProduct(Long id) {
		Product product = getProductById(id);
		repo.delete(product);
		return new StringBuilder().append("Product with id : ").append(id).append(" is deleted successfully!").toString();
	}
	
	@Override
	public String updateProduct(Long id, ProductDto uiProduct) {
		Product dbProduct = getProductById(id);
		Product updatedProduct = AppUtil.copyProductObject(dbProduct,uiProduct);
		updatedProduct.setUpdatedBy("Admin");
		repo.save(updatedProduct);
		return new StringBuilder().append("Product with id : ").append(id).append(" updated successfully!").toString();
	}
}
