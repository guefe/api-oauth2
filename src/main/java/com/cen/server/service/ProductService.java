package com.cen.server.service;

import com.cen.server.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findProducts(Product filter);
    Product findProduct(Integer id);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
    Product createProduct(Product product);



}
