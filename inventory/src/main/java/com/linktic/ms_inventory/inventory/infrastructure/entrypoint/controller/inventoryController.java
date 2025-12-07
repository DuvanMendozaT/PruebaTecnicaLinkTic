package com.linktic.ms_inventory.inventory.infrastructure.entrypoint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class inventoryController {

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);
    private static final String RESOURCE_TYPE = "inventory";

    //private final InventoryService inventoryService;

    @Operation(
            summary = "Consultar cantidad disponible de un producto",
            description = "Devuelve la cantidad disponible de un producto específico, obteniendo información del producto desde el microservicio de productos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventario encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto o inventario no encontrado")
    })
    @GetMapping("/{productId}")
    public ResponseEntity<JsonApiResponse<InventoryResponse>> getInventoryByProductId(
            @Parameter(description = "ID del producto") @PathVariable Long productId) {

        InventoryResponse response = inventoryService.getInventoryByProductId(productId);

        JsonApiData<InventoryResponse> data = new JsonApiData<>(
                RESOURCE_TYPE,
                response.productId().toString(),
                response
        );

        return ResponseEntity.ok(new JsonApiResponse<>(data));
    }

    @Operation(
            summary = "Actualizar inventario tras compra",
            description = "Descuenta la cantidad comprada del inventario, valida que sea suficiente y emite un evento simple (log) cuando cambia el inventario."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inventario actualizado"),
            @ApiResponse(responseCode = "400", description = "Cantidad inválida o stock insuficiente"),
            @ApiResponse(responseCode = "404", description = "Producto o inventario no encontrado")
    })
    @PatchMapping("/{productId}/purchase")
    public ResponseEntity<JsonApiResponse<InventoryResponse>> purchaseProduct(
            @Parameter(description = "ID del producto") @PathVariable Long productId,
            @Valid @RequestBody PurchaseRequest request) {

        InventoryResponse updated = inventoryService.purchaseProduct(productId, request.quantity());

        // Evento simple: log de cambio de inventario
        log.info("Inventory changed for product {}. New quantity: {}", updated.productId(), updated.quantity());

        JsonApiData<InventoryResponse> data = new JsonApiData<>(
                RESOURCE_TYPE,
                updated.productId().toString(),
                updated
        );

        return ResponseEntity.ok(new JsonApiResponse<>(data));
    }
}
