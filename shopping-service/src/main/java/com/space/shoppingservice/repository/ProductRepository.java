package com.space.shoppingservice.repository;

import com.space.shoppingservice.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ProductRepository {
    Iterable<Product> findAll();
    Optional<Product> findBySku(String sku);
    boolean existsBySku(String sku);
    Product save(Product product);
    void deleteProductBySku(String sku);
}
