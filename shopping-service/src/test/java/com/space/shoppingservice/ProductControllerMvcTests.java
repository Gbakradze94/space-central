package com.space.shoppingservice;

import com.space.shoppingservice.api.ProductController;
import com.space.shoppingservice.service.ProductNotFoundException;
import com.space.shoppingservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void whenGetNonExistingProductThenShouldReturn404() throws Exception {
        String sku = "00000";
        given(productService.viewProductDetails(sku))
                .willThrow(ProductNotFoundException.class);

        mockMvc
                .perform(get("/products/" + sku))
                .andExpect(status().isNotFound());
    }
}
