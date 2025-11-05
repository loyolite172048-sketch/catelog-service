package com.BookStore.Catelog.service;

import com.BookStore.Catelog.entity.PagedResult;
import com.BookStore.Catelog.entity.Product;
import com.BookStore.Catelog.entity.ProductEntity;
import com.BookStore.Catelog.entity.ProductMapper;
import com.BookStore.Catelog.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {


    private final ProductRepository repo;

    ProductService(ProductRepository repo){
        this.repo = repo;
    }

    public PagedResult<Product> getProducts(int pageNo){
        Sort sort = Sort.by("name").ascending();
        pageNo = pageNo <= 1 ? 0 : pageNo -1;
        Pageable page  = PageRequest.of(pageNo, 10, sort);
        Page<Product> productPage =
                repo.findAll(page).map(ProductMapper::toProduct);

        return new PagedResult<>(
                productPage.getContent(),
                productPage.getTotalElements(),
                productPage.getNumber() + 1,
                productPage.getTotalPages(),
                productPage.isFirst(),
                productPage.isLast(),
                productPage.hasNext(),
                productPage.hasPrevious()
        );

    }
}
