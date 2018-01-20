package com.cen.server.service.impl;

import com.cen.server.entity.Product;
import com.cen.server.repository.ProductRepository;
import com.cen.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void createProduct(Product product) {

    }
}
