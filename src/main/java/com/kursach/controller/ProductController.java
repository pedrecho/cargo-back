package com.kursach.controller;

import com.kursach.entity.Product;
import com.kursach.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('STAFF_MEMBER')")
    public Collection<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ASSISTANT_MANAGER', 'MANAGER', 'ADMIN')")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public void removeProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }

}
