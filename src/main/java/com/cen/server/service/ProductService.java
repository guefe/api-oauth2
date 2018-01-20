package com.cen.server.service;

import com.cen.server.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);
    void createProduct(Product product);



}
