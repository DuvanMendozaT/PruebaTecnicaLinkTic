package com.linktic.ms_inventory.inventory.domain.model;

import lombok.Data;

@Data
public class InventoryModel {

    private Long id;

    private Long productId;

    private Integer quantity;
}
