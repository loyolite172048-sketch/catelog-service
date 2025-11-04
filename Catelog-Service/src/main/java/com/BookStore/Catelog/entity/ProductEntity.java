package com.BookStore.Catelog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productId_Generator")
    @SequenceGenerator(name = "productId_Generator", sequenceName = "product_id_seq")
    private long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "product code is required")
    private String code;

    @Column(nullable = false)
    @NotEmpty(message = "product name is required")
    private String name;

    private String description;

    private String imageUrl;

    @Column(nullable = false)
    @DecimalMin("0.1")
    @NotEmpty(message = "product price is required")
    private BigDecimal price;
}
