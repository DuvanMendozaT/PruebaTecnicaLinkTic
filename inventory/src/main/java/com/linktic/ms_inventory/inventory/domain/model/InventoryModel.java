package com.linktic.ms_inventory.inventory.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryModel {

    private Long id;

    private Long productId;

    private Integer quantity;
}
