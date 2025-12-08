package com.linktic.ms_inventory.inventory.domain.service;

import com.linktic.ms_inventory.inventory.application.Constants;
import com.linktic.ms_inventory.inventory.application.dto.PurchaseRequest;
import com.linktic.ms_inventory.inventory.domain.exeption.InventpryNotFoundException;
import com.linktic.ms_inventory.inventory.domain.model.InventoryModel;
import com.linktic.ms_inventory.inventory.domain.model.ProductModel;
import com.linktic.ms_inventory.inventory.domain.port.ExternalProductApiPort;
import com.linktic.ms_inventory.inventory.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements  InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ExternalProductApiPort externalProductApiPort;

    @Override
    public InventoryModel getProductInventory(Long productId) {
             return inventoryRepository.findById(productId)
                .orElseThrow(() -> new InventpryNotFoundException(Constants.PRODUCT_NOT_FOUND));
    }

    @Override
    public InventoryModel purchaseProduct(PurchaseRequest request) {

        InventoryModel inventoryModel = getProductInventory(request.getProductId());

        var quantity = inventoryModel.getQuantity();

        inventoryModel.setQuantity(quantity - request.getQuantity());

        //log.info("Inventory changed for product {}. New quantity: {}", request.getProductId(), request.getQuantity());

        return  inventoryRepository.save(inventoryModel);
    }

    @Override
    public ProductModel getProductDetails(Long productId) {
        return externalProductApiPort.getProductDetails(productId);
    }



}
