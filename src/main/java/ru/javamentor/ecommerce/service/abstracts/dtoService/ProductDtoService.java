package ru.javamentor.ecommerce.service.abstracts.dtoService;


import ru.javamentor.ecommerce.models.dto.ProductDto;

import java.util.List;

public interface ProductDtoService {
    List<ProductDto> getAllBooksDto(int page, int size);

    Long getAmountOfPagesForBooks();

    List<ProductDto> getAllCoffeeMugsDto();

    List<ProductDto> getAllMousePadsDto();

    List<ProductDto> getAllLuggageTagsDto();
}
