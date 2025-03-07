package com.eshop.shopper.service;

import com.eshop.shopper.model.Product;
import com.eshop.shopper.payload.ProductDTO;
import com.eshop.shopper.payload.ProductResponse;

public interface IProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();
    ProductDTO getProductById(Long productId);

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);

    ProductDTO deleteProduct(Long productId);
}
