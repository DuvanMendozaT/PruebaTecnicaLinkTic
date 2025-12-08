package com.linktic.ms_inventory.inventory.infrastructure.rest.controller;

import com.linktic.ms_inventory.inventory.application.dto.JsonApiResponse;
import com.linktic.ms_inventory.inventory.application.dto.InventoryRequest;
import com.linktic.ms_inventory.inventory.application.handler.InventoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@Tag(name ="Inventory resources")
public class inventoryController {

    @Autowired
    private InventoryHandler inventoryHandler;

    @Operation(
            summary = "Consultar cantidad disponible de un producto",
            description = "Devuelve la cantidad disponible de un producto específico, obteniendo información del producto desde el microservicio de productos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventario encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto o inventario no encontrado")
    })
    @GetMapping("/{productId}")
    public ResponseEntity<JsonApiResponse> getInventoryByProductId(
            @Parameter(description = "ID del producto") @PathVariable Long productId) {
        return inventoryHandler.getInventoryByProductId(productId);
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
    @PatchMapping("/purchase")
    public ResponseEntity<JsonApiResponse> purchaseProduct(
            @Valid @RequestBody InventoryRequest request) {

        return inventoryHandler.purchaseProduct(request);
    }

    @Operation(summary = "Crear un nuevo inventario", description = "Crea un inventario y devuelve el recurso ")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "inventario creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<JsonApiResponse> createInventory(
            @Valid @RequestBody InventoryRequest productRequest) {

        return inventoryHandler.createInventory(productRequest);
    }
}
