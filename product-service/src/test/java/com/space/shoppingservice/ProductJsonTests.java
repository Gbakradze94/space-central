package com.space.shoppingservice;

import com.space.shoppingservice.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class ProductJsonTests {
    @Autowired
    private JacksonTester<Product> json;

    @Test
    void testSerialize() throws IOException {
        var product = Product.of("1234567890", "IPhone 15", "Iphone 15 Smartphone", 1000.0);
        var jsonContent = json.write(product);
        assertThat(jsonContent).extractingJsonPathStringValue("@.sku")
                .isEqualTo(product.sku());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(product.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.description")
                .isEqualTo(product.description());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(product.price());
    }

    @Test
    void testDeserialize() throws IOException {
        var content = """
               {
                  "sku": "1234567890",
                  "title": "Iphone 15",
                  "description": "IPhone smartphone",
                  "price": 1000.0
                }
                """;
        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(Product.of("1234567890", "Iphone 15", "IPhone smartphone", 1000.0));
    }
}
