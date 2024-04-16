package com.space.shoppingservice.demo;

import com.space.shoppingservice.domain.Product;
import com.space.shoppingservice.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class ProductDataLoader {
    private final ProductRepository productRepository;
    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener
    public void loadProductTestData() {
        var product1 = new Product("1234567890", "Ear phones", "Eap phones", 45.00);
        var product2 = new Product("1234567880", "Samsung SM-860", "Smart watch", 500.00);
        productRepository.save(product1);
        productRepository.save(product2);
    }
}
