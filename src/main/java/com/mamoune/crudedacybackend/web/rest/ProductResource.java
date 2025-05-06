package com.mamoune.crudedacybackend.web.rest;

import com.mamoune.crudedacybackend.domain.Product;
import com.mamoune.crudedacybackend.service.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductResource {
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product savedProduct = productService.update(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product products = this.productService.getProduct(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = this.productService.getAllProducts(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
