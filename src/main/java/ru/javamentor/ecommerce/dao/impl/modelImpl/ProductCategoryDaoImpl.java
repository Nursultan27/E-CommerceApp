package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.ProductCategoryDao;
import ru.javamentor.ecommerce.models.entities.ProductCategory;

@Repository
public class ProductCategoryDaoImpl extends ReadWriteDaoImpl<ProductCategory, Long> implements ProductCategoryDao {

}
