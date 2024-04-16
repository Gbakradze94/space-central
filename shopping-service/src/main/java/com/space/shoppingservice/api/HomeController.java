package com.space.shoppingservice.api;

import com.space.shoppingservice.ShoppingProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final ShoppingProperties shoppingProperties;

    public HomeController(ShoppingProperties shoppingProperties) {
        this.shoppingProperties = shoppingProperties;
    }
    @GetMapping("/")
    public String getGreeting() {
        return shoppingProperties.getGreeting();
    }
}
