package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.ProductCategoryDao;

import ru.javamentor.ecommerce.models.entities.ProductCategory;
import ru.javamentor.ecommerce.service.abstracts.modelService.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends ReadWriteServiceImpl<ProductCategory, Long> implements ProductCategoryService {
    private final ProductCategoryDao productCategoryDao;

    public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao) {
        super(productCategoryDao);
        this.productCategoryDao = productCategoryDao;
    }
}
