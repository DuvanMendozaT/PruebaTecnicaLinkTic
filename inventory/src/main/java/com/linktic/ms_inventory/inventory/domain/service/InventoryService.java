package com.linktic.ms_inventory.inventory.domain.service;

import com.linktic.ms_inventory.inventory.application.dto.InventoryRequest;
import com.linktic.ms_inventory.inventory.domain.model.InventoryModel;
import com.linktic.ms_inventory.inventory.domain.model.ProductModel;

public interface InventoryService {
    InventoryModel getProductInventory(Long productId);

    InventoryModel purchaseProduct(InventoryRequest request);

    ProductModel getProductDetails(Long productId);

    InventoryModel createInventory(InventoryRequest productRequest);
}
