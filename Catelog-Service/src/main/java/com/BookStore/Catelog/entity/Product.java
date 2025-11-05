package com.BookStore.Catelog.entity;

import java.math.BigDecimal;

public record Product(
        String name,
        String code,
        String imageUrl,
        BigDecimal price,
        String description
){

}

