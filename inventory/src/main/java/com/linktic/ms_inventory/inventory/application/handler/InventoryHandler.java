package com.linktic.ms_inventory.inventory.application.handler;

import com.linktic.ms_inventory.inventory.application.Constants;
import com.linktic.ms_inventory.inventory.application.dto.JsonApiData;
import com.linktic.ms_inventory.inventory.application.dto.JsonApiResponse;
import com.linktic.ms_inventory.inventory.application.dto.PurchaseRequest;
import com.linktic.ms_inventory.inventory.domain.model.InventoryModel;
import com.linktic.ms_inventory.inventory.domain.model.ProductModel;
import com.linktic.ms_inventory.inventory.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class InventoryHandler {

    @Autowired
    private InventoryService inventoryService;
    public ResponseEntity<JsonApiResponse> getInventoryByProductId(Long productId) {

        //consulta de inventario
        InventoryModel inventoryModel = inventoryService.getProductInventory(productId);

        //consulta de informacion de producto
        ProductModel productModel = inventoryService.getProductDetails(productId);

        //construccion de respuesta



        return processResponse(Constants.SUCCESSFULLY_STATUS, inventoryModel.getQuantity(), productModel); //respuesta con info de producto
    }

    public ResponseEntity<JsonApiResponse> purchaseProduct(PurchaseRequest request) {

        InventoryModel inventoryModel = inventoryService.purchaseProduct(request);

        ProductModel productModel = inventoryService.getProductDetails(request.getProductId());

        return processResponse(Constants.SUCCESSFULLY_STATUS,inventoryModel.getQuantity(), productModel); //respuesta con info de producto

    }


    public ResponseEntity<JsonApiResponse> processResponse(String status,int quantity, ProductModel productModel){
        JsonApiData<Object> body = JsonApiData.builder()
                .status(status)
                .message(Constants.PRODUCT_INVENTORY_MESSAGE + productModel.getId() + Constants.MESSAGE_AUX +  quantity)
                .attributes(productModel)
                .build();

        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.ok().body(response);
    }


}
