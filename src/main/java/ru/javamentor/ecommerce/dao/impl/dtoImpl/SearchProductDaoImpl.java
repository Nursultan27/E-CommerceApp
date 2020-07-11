package ru.javamentor.ecommerce.dao.impl.dtoImpl;

import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.dtoDao.SearchProductDao;
import ru.javamentor.ecommerce.dao.impl.modelImpl.ReadWriteDaoImpl;
import ru.javamentor.ecommerce.models.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class SearchProductDaoImpl extends ReadWriteDaoImpl<ProductDto, Long> implements SearchProductDao {
    @Override
    public List<ProductDto> getProductsSortedByСategory(Integer category_id) {
        return null;
    }

    @Override
    @SuppressWarnings({"unchecked", "deprecated"})
    public List<ProductDto> search(String text) {
        return entityManager.createQuery("SELECT " +
                "p.id, " +
                "p.name, " +
                "p.description, " +
                "p.unitPrice, " +
                "p.imageUrl " +
//                "FROM Product p WHERE p.name LIKE '%' :t '%'")
                "FROM Product p WHERE p.name LIKE CONCAT('%', :t, '%')")
                .setParameter("t", text)
                .unwrap(Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] objects, String[] strings) {
                        return ProductDto.builder()
                                .id((Long) objects[0])
                                .name((String) objects[1])
                                .description((String) objects[2])
                                .unitPrice((BigDecimal) objects[3])
                                .imageUrl((String) objects[4])
                                .build();
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                })
                .getResultList();
    }
}
