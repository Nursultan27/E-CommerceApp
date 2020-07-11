package ru.javamentor.ecommerce.dao.abstracts.dtoDao;

import ru.javamentor.ecommerce.models.dto.ProductDto;

import java.util.List;

public interface SearchProductDao {

    List<ProductDto> getProductsSortedByСategory(Integer category_id);

    List<ProductDto> search(String text);
}
