package com.space.shoppingservice.service;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String sku) {
        super("The product with SKU: " + sku + " was not found.");
    }
}
