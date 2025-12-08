package com.linktic.ms_inventory.inventory.domain.service;

import com.linktic.ms_inventory.inventory.application.dto.PurchaseRequest;
import com.linktic.ms_inventory.inventory.domain.model.InventoryModel;
import com.linktic.ms_inventory.inventory.domain.model.ProductModel;

public interface InventoryService {
    InventoryModel getProductInventory(Long productId);

    InventoryModel purchaseProduct(PurchaseRequest request);

    ProductModel getProductDetails(Long productId);
}
