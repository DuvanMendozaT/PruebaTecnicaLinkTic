package com.linktic.ms_products.product.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TBL_PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_ID_PRODUCT")
    private Long id;

    @Column(name = "STR_NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "NUM_PRICE", nullable = false, precision = 15, scale = 2)
    private BigDecimal price;
}