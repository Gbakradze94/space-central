package com.space.shoppingservice;

import com.space.shoppingservice.domain.Product;
import com.space.shoppingservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getProductsList() {
        return productService.viewProductList();
    }

    @GetMapping("{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        return productService.viewProductDetails(sku);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductBySku(@PathVariable  String sku) {
        productService.deleteProductBySku(sku);
    }

    @PutMapping("{isbn}")
    public Product editProduct(@PathVariable String sku, @RequestBody Product product) {
        return productService.editProductDetails(sku, product);
    }
}
