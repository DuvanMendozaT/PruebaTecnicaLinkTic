package com.linktic.ms_products.product.infrastructure.rest.controller;

import com.linktic.ms_products.product.application.dto.api.*;
import com.linktic.ms_products.product.application.handler.ProductHandler;
import com.linktic.ms_products.product.domain.model.ProductModel;
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
@RequestMapping("/products")
@Tag(name ="Product resources")
public class ProductController {


    @Autowired
    private ProductHandler productHandler;

    @Operation(summary = "Crear un nuevo producto", description = "Crea un producto y devuelve el recurso en formato JSON:API.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Producto creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<JsonApiResponse> createProduct(
            @Valid @RequestBody ProductRequest productRequest) {

        return productHandler.createProduct(productRequest);
    }

    @Operation(summary = "Obtener un producto por ID", description = "Retorna un producto específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> getProductById(
            @Parameter(description = "ID del producto") @PathVariable Long id) {

        return productHandler.getById(id);
    }

    @Operation(summary = "Actualizar un producto por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto actualizado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<JsonApiResponse> updateProduct(
            @Parameter(description = "ID del producto") @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        return productHandler.updateProduct(id, request);
    }

    @Operation(summary = "Eliminar un producto por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Producto eliminado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<JsonApiResponse> deleteProduct(
            @Parameter(description = "ID del producto") @PathVariable Long id) {

        return productHandler.deleteProduct(id);
    }


    @Operation(summary = "Listar productos con paginación simple")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de productos")
    })
    @GetMapping
    public ResponseEntity<JsonApiListResponse> listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return productHandler.listProducts(page, size);
    }
}