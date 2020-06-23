package ru.javamentor.ecommerce.webapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.ecommerce.models.dto.ProductDto;
import ru.javamentor.ecommerce.service.abstracts.dtoService.ProductDtoService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductDtoService productDtoService;

    @Autowired
    public ProductController(@Qualifier("productDtoServiceImpl") ProductDtoService productDtoService) {
        this.productDtoService = productDtoService;
    }


    @GetMapping("/api/books")
    public ResponseEntity<List<ProductDto>> getAllBooks() {
        return new ResponseEntity<>(productDtoService.getAllBooksDto(), HttpStatus.OK);
    }
}
