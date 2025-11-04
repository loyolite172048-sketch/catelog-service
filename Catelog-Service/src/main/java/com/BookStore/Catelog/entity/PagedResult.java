package com.BookStore.Catelog.entity;

import java.util.List;

public record PagedResult<T> (
        List<T> Data,
        long totalElements,
        int pageNUmber,
        int totalPages,
        boolean isFirst,
        boolean isLast,
        boolean hasNext,
        boolean hasPrevious
){}
