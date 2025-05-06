package com.mamoune.crudedacybackend.service.impl;

import com.mamoune.crudedacybackend.domain.Product;
import com.mamoune.crudedacybackend.repository.ProductRepository;
import com.mamoune.crudedacybackend.service.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public Product update(Product product) {
        if (this.productRepository.existsById(product.getId())) {
            Product product1 = this.productRepository.findById(product.getId()).orElse(null);
            if (product1 != null) {
                product1.setLabel(product.getLabel());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
                product1.setDescription(product.getDescription());
                return this.productRepository.save(product1);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Product getProduct(String id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    };

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElse(null);
        if (product != null) {
            this.productRepository.delete(product);
        }
    }
}
