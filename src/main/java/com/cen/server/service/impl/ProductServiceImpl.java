package com.cen.server.service.impl;

import com.cen.server.entity.Product;
import com.cen.server.repository.ProductRepository;
import com.cen.server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class.getName());
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProducts(Product filter) {
        logger.debug("Retrieving products");
        if (filter != null && !filter.isEmpty()) {
            return productRepository.findAll(Example.of(filter));
        }else {
            return productRepository.findAll();
        }
    }

    @Override
    public Optional<Product> findProduct(Integer id) {
        logger.debug("Retrieving product with id: "+id);
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        logger.debug("updating");
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
        this.productRepository.getOne(id);
        logger.debug("Deleted product with id: " + id);
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreationDate(new Date());
        Product newProduct = this.productRepository.save(product);
        logger.debug("Inserted new product with id: " + newProduct.getId());
        return newProduct;
    }
}
