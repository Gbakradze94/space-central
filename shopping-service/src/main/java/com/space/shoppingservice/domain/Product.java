package com.space.shoppingservice.domain;

import jakarta.validation.constraints.NotBlank;

public record Product(
    String sku,
    String title,
    String description,
    Double price
) {

}
