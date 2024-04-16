package com.space.shoppingservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Product(
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
    Double price
) {

}
