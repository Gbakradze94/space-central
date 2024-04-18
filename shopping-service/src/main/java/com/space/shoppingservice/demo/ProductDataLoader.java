package com.space.shoppingservice.demo;

import com.space.shoppingservice.domain.Product;
import com.space.shoppingservice.repository.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class ProductDataLoader {
    private final ProductRepository productRepository;
    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadProductTestData() {
        productRepository.deleteAll();
        var product1 = Product.of("1234567890", "Ear phones", "Eap phones", 45.00);
        var product2 = Product.of("1234567880", "Samsung SM-860", "Smart watch", 500.00);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.saveAll(List.of(product1, product2));
    }
}
