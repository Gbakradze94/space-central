package com.space.shoppingservice.repository;

import com.space.shoppingservice.domain.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAll();
    Optional<Product> findBySku(String sku);
    boolean existsBySku(String sku);
    Product save(Product product);

    @Modifying
    @Transactional
    // Declares the query that Spring Data will use to implement the method
    @Query("delete FROM Product where sku = :sku")
    void deleteProductBySku(String sku);
}
