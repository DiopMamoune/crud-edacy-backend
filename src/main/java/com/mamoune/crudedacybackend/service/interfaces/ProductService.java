package com.mamoune.crudedacybackend.service.interfaces;

import com.mamoune.crudedacybackend.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product save(Product product);
    Product update(Product product);
    Product getProduct(String id);
    Page<Product> getAllProducts(Pageable pageable);
    void delete(String id);
}
