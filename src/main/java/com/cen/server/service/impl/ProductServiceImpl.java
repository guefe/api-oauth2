package com.cen.server.service.impl;

import com.cen.server.entity.Product;
import com.cen.server.repository.ProductRepository;
import com.cen.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findProducts(Product filter) {
        log.info("Retrieving products");
        if (filter != null && !filter.isEmpty()) {
            return productRepository.findAll(Example.of(filter));
        } else {
            return productRepository.findAll();
        }
    }

    @Override
    public Optional<Product> findProduct(Integer id) {
        log.info("Retrieving product with id: " + id);
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        log.info("updating");
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
        this.productRepository.getOne(id);
        log.info("Deleted product with id: {}", id);
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreationDate(new Date());
        Product newProduct = this.productRepository.save(product);
        log.info("Inserted new product with id: " + newProduct.getId());
        return newProduct;
    }
}
