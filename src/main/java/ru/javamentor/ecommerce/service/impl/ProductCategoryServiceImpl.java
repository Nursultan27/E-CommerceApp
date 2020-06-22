package ru.javamentor.ecommerce.service.impl;

import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.dao.abstracts.ProductCategoryDao;

import ru.javamentor.ecommerce.models.entities.ProductCategory;
import ru.javamentor.ecommerce.service.abstracts.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends ReadWriteServiceImpl<ProductCategory, Long> implements ProductCategoryService {
    private final ProductCategoryDao productCategoryDao;

    public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao) {
        super(productCategoryDao);
        this.productCategoryDao = productCategoryDao;
    }
}
