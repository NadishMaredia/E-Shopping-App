package com.eshop.shopper.repository;

import com.eshop.shopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
