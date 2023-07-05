package com.ngsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngsb.dto.Message;
import com.ngsb.dto.ProductDto;
import com.ngsb.entity.Product;
import com.ngsb.exeption.ProductNotFoundException;
import com.ngsb.service.IProductService;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Message> saveProduct(@RequestBody ProductDto productDto) {
		String msg = productService.saveProduct(productDto);
		return new ResponseEntity<>(new Message("Success", msg), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> allProduct = productService.getAllProduct();
		return new ResponseEntity<>(allProduct, HttpStatus.OK);
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id) {
		try {
			return ResponseEntity.ok(productService.getProductById(id));
		} catch (ProductNotFoundException pnfe) {
			throw pnfe;
		} catch (Exception e) {
			throw e;
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Message> deleteProudct(@PathVariable(name = "id") Long id) {
		try {
			return ResponseEntity.ok(new Message("Success", productService.deleteProduct(id)));
		} catch (ProductNotFoundException pnfe) {
			throw pnfe;
		} catch (Exception e) {
			throw e;
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Message> updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductDto product) {
		try {
			String response = productService.updateProduct(id, product);
			return ResponseEntity.ok(new Message("Success", response));
		} catch (ProductNotFoundException pnfe) {
			throw pnfe;
		} catch (Exception e) {
			throw e;
		}
	}

}
