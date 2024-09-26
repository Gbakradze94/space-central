package com.space.shoppingservice.domain;

import com.space.shoppingservice.config.ShoppingDataConfig;
import com.space.shoppingservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@Import(ShoppingDataConfig.class)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("integration")
public class ProductRepositoryJdbcTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findProductBySkuWhenExisting() {
        var productSku = "1234567890";
        var product = Product.of(productSku, "IPhone 15", "Iphone 15 Smartphone", 1200.0);

        jdbcAggregateTemplate.insert(product);
        Optional<Product> actualProduct = productRepository.findBySku(productSku);

        assertThat(actualProduct).isPresent();
        assertThat(actualProduct.get().sku()).isEqualTo(product.sku());
    }
}
