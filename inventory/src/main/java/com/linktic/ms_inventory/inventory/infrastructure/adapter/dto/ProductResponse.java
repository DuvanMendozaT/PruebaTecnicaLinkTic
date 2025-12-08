package com.linktic.ms_inventory.inventory.infrastructure.adapter.dto;

import com.linktic.ms_inventory.inventory.domain.model.ProductModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    String status;
    String message;
    ProductModel product;
}
