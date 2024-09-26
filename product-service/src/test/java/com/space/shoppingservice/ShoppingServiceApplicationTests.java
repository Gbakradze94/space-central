package com.space.shoppingservice;

import com.space.shoppingservice.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ShoppingServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenPostRequestThenProductCreated() {
		var expectedProduct = Product.of("1234567890", "GoPro Hero 7", "Action camera", 1500.0);

		webTestClient.post()
				.uri("/products")
				.bodyValue(expectedProduct)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Product.class).value(actualProduct -> {
					assertThat(actualProduct).isNotNull();
					assertThat(actualProduct.sku())
							.isEqualTo(expectedProduct.sku());
				});
	}

	@Test
	void contextLoads() {
	}
}
