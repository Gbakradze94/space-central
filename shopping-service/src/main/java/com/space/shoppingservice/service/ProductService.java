package com.space.shoppingservice.service;

import com.space.shoppingservice.domain.Product;
import com.space.shoppingservice.exception.ProductAlreadyExistsException;
import com.space.shoppingservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> viewProductList() {
        return productRepository.findAll();
    }

    public Product viewProductDetails(String sku) {
        return productRepository.findBySku(sku)
                .orElseThrow(() -> new ProductNotFoundException(sku));
    }

    public Product addProduct(Product product) {
        if (productRepository.existsBySku(product.sku())) {
            throw new ProductAlreadyExistsException(product.sku());
        }
        return productRepository.save(product);
    }

    public void deleteProductBySku(String sku) {
        productRepository.deleteProductBySku(sku);
    }

    public Product editProductDetails(String sku, Product product) {
        return productRepository.findBySku(sku)
                .map(existingProduct -> {
                    var productToUpdate = new Product(
                            existingProduct.sku(),
                            product.title(),
                            product.description(),
                            product.price()
                    );
                    return productRepository.save(productToUpdate);
                })
                .orElseGet(() -> addProduct(product));
    }
}
