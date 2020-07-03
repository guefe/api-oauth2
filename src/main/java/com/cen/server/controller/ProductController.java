package com.cen.server.controller;

import com.cen.server.entity.Product;
import com.cen.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findProducts(@ModelAttribute Product filter){

        List<Product> products = productService.findProducts(filter);

        return ResponseEntity.ok(products);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getPoduct(@PathVariable("id") Integer id){

        Optional<Product> product = productService.findProduct(id);
        if (product.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
   }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Product product){

        Product newProduct = this.productService.createProduct(product);

        return ResponseEntity.created(URI.create("/api/products/"+newProduct.getId())).body(newProduct);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product){

        if (productService.findProduct(id).isPresent()){
            this.productService.updateProduct(product);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){

        if (productService.findProduct(id).isPresent()){
            this.productService.deleteProduct(id);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
