package com.BookStore.Catelog.controllers;

import com.BookStore.Catelog.entity.PagedResult;
import com.BookStore.Catelog.entity.Product;
import com.BookStore.Catelog.entity.ProductEntity;
import com.BookStore.Catelog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Products")
class ProductController {

    private final ProductService service;

    ProductController(ProductService service){
        this.service = service;
    }

    public PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue="1") int pageNo){
        return service.getProducts(pageNo);
    }
}
