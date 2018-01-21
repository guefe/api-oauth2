package com.cen.server.controller;

import com.cen.server.entity.Product;
import com.cen.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<?> findProducts(@ModelAttribute Product filter){

        List<Product> products = productService.findProducts(filter);

        return ResponseEntity.ok(products);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<?> getPoduct(@PathVariable("id") Integer id){

        Product product = productService.findProduct(id);
        if (product == null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
   }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createProduct(@RequestBody Product product){

        Product newProduct = this.productService.createProduct(product);

        return ResponseEntity.created(URI.create("/api/products/"+newProduct.getId())).body(newProduct);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product){

        if (productService.findProduct(id) != null){
            this.productService.updateProduct(product);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){

        if (productService.findProduct(id) != null){
            this.productService.deleteProduct(id);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
