package ru.javamentor.ecommerce.service.impl.dtoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.ecommerce.dao.abstracts.dtoDao.ProductDtoDao;
import ru.javamentor.ecommerce.models.dto.ProductDto;
import ru.javamentor.ecommerce.service.abstracts.dtoService.ProductDtoService;

import java.util.List;

@Service
public class ProductDtoServiceImpl implements ProductDtoService {
    private ProductDtoDao productDtoDao;

    @Autowired
    public ProductDtoServiceImpl(ProductDtoDao productDtoDao) {
        this.productDtoDao = productDtoDao;
    }

    @Override
    @Transactional
    public List<ProductDto> getAllBooksDto(int page, int size) {
        return productDtoDao.getAllBooksDto(page, size);
    }

    @Override
    @Transactional
    public Long getAmountOfPagesForBooks() {
        return productDtoDao.getAmountOfPagesForBooks();
    }


    @Override
    @Transactional
    public List<ProductDto> getAllCoffeeMugsDto() {
        return null;
    }

    @Override
    @Transactional
    public List<ProductDto> getAllMousePadsDto() {
        return null;
    }

    @Override
    @Transactional
    public List<ProductDto> getAllLuggageTagsDto() {
        return null;
    }
}
