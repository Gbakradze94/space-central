package com.space.shoppingservice.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String sku) {
        super("The product with SKU: " + sku + " was not found.");
    }
}
