package ru.javamentor.ecommerce.dao.abstracts.dtoDao;

import ru.javamentor.ecommerce.models.dto.ProductDto;

import java.util.List;

public interface ProductDtoDao {
    List<ProductDto> getAllBooksDto();

    List<ProductDto> getAllCoffeeMugsDto();

    List<ProductDto> getAllMousePadsDto();

    List<ProductDto> getAllLuggageTagsDto();
}
