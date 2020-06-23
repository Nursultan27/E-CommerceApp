package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.ProductDao;
import ru.javamentor.ecommerce.models.entities.Product;

@Repository
public class ProductDaoImpl extends ReadWriteDaoImpl<Product, Long> implements ProductDao {

}
