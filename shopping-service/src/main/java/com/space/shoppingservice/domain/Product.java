package com.space.shoppingservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Product(
        @Id
        Long id,
        @NotBlank(message = "The product SKU must be defined")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The SKU format must be valid."
        )
        String sku,
        @NotBlank(
                message = "The product title must be defined."
        )
        String title,
        @NotBlank(
                message = "The product description cannot be blank."
        )
        String description,
        @NotNull(message = "The product price must be defined.")
        @Positive(
                message = "The product price must be greater than zero."
        )
        Double price,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
        int version
) {
    public static Product of(String sku, String title, String description, Double price) {
        return new Product(null, sku, title, description, price, null, null,0);
    }
}
