package com.BookStore.Catelog.entity;

public class ProductMapper {
    public static Product toProduct(ProductEntity productEntity){
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getImageUrl(),
                productEntity.getPrice(),
                productEntity.getDescription()
        );
    }

}
