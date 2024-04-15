package com.space.shoppingservice.demo;

import com.space.shoppingservice.domain.Product;
import com.space.shoppingservice.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private static final Map<String, Product> products =
            new ConcurrentHashMap<>();
    @Override
    public Iterable<Product> findAll() {
        return products.values();
    }

    @Override
    public Optional<Product> findBySku(String sku) {
       return existsBySku(sku) ?
               Optional.of(products.get(sku)) : Optional.empty();
    }

    @Override
    public boolean existsBySku(String sku) {
        return products.get(sku) != null;
    }

    @Override
    public Product save(Product product) {
        products.put(product.sku(), product);
        return product;
    }

    @Override
    public void deleteProductBySku(String sku) {
        products.remove(sku);
    }
}
