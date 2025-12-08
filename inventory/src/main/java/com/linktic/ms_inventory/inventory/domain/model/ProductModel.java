package com.linktic.ms_inventory.inventory.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductModel {
    Long id;

    String name;

    BigDecimal price;
}
