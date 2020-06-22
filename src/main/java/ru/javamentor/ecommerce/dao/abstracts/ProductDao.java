package ru.javamentor.ecommerce.dao.abstracts;

import ru.javamentor.ecommerce.models.entities.Product;

import java.util.List;

public interface ProductDao extends ReadWriteDao<Product, Long> {
    List<Product> getAllBooks();
}
