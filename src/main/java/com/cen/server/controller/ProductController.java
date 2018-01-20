package com.cen.server.controller;

import com.cen.server.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value="/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> greet(){
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        String username = ((User)authentication.getPrincipal()).getUsername();
        return ResponseEntity.ok("Hello, "+username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<?> getPoduct(@PathVariable("id") Integer id){
        Product p = new Product();
        p.setId(8);
        p.setName("dsasf");
        return ResponseEntity.ok(p);
    }
}
