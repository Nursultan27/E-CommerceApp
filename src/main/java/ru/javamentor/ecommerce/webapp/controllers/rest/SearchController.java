package ru.javamentor.ecommerce.webapp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.ecommerce.dao.abstracts.dtoDao.SearchProductDao;
import ru.javamentor.ecommerce.models.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchProductDao searchProductDao;

    @Autowired
    public SearchController(SearchProductDao searchProductDao) {
        this.searchProductDao = searchProductDao;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> search(@RequestParam("search") String search) {
        List<ProductDto> abc = searchProductDao.search(search);
        return new ResponseEntity<>(searchProductDao.search(search), HttpStatus.OK);
    }
}
