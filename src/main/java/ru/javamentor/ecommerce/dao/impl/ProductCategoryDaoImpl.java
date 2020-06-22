package ru.javamentor.ecommerce.dao.impl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.ProductCategoryDao;
import ru.javamentor.ecommerce.models.entities.ProductCategory;

@Repository
public class ProductCategoryDaoImpl extends ReadWriteDaoImpl<ProductCategory, Long> implements ProductCategoryDao {

}
