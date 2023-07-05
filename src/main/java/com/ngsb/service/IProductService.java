package com.ngsb.service;

import java.util.List;

import com.ngsb.dto.ProductDto;
import com.ngsb.entity.Product;

public interface IProductService {
	String saveProduct(ProductDto productDto);
	List<Product> getAllProduct();
	Product getProductById(Long id);
	String deleteProduct(Long id);
	String updateProduct(Long id,ProductDto product);
}
