package com.ngsb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngsb.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
