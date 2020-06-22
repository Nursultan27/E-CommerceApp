package ru.javamentor.ecommerce.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.ecommerce.dao.abstracts.ProductDao;
import ru.javamentor.ecommerce.models.entities.Product;

import java.util.List;

@Repository
public class ProductDaoImpl extends ReadWriteDaoImpl<Product, Long> implements ProductDao {

    public List<Product> getAllBooks() {
        return entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.category.id = 1", Product.class).getResultList();
    }

    public Product findProductByNameContaining(@RequestParam("name") String name) {
        return null;
    }
}
