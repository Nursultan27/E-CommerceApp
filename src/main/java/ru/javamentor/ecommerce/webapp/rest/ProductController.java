package ru.javamentor.ecommerce.webapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.ecommerce.service.abstracts.ProductService;
import ru.javamentor.ecommerce.models.entities.Product;

import java.util.List;

@RestController

public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/books")
    public List<Product> getAllBooks() {
        return productService.getAllBooks();
    }
}
