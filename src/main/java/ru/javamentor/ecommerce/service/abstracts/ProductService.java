package ru.javamentor.ecommerce.service.abstracts;

import ru.javamentor.ecommerce.models.entities.Product;

import java.util.List;

public interface ProductService extends ReadWriteService<Product, Long> {
    List<Product> getAllBooks();
}
