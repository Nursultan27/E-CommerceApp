package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.ProductDao;
import ru.javamentor.ecommerce.models.entities.Product;
import ru.javamentor.ecommerce.service.abstracts.modelService.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl extends ReadWriteServiceImpl<Product, Long> implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }
}