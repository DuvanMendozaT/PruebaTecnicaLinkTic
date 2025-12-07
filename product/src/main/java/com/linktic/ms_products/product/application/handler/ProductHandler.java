package com.linktic.ms_products.product.application.handler;

import com.linktic.ms_products.product.application.Constants;
import com.linktic.ms_products.product.application.dto.api.*;
import com.linktic.ms_products.product.domain.model.ProductModel;
import com.linktic.ms_products.product.domain.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductHandler {

    @Autowired
    private ProductService productService;

    public ResponseEntity<JsonApiResponse> createProduct(ProductRequest productRequest){

        ProductModel productModel = productService.createProduct(productRequest);
        return processResponse(Constants.SUCCESSFULLY_STATUS,Constants.PRODUCT_CREATED_SUCCESSFULLY, productModel);
    }

    public ResponseEntity<JsonApiResponse> getById(Long id) {
        ProductModel productModel = productService.getById(id);
        return processResponse(Constants.SUCCESSFULLY_STATUS,Constants.PRODUCT_FOUND, productModel);
    }


    public ResponseEntity<JsonApiResponse> updateProduct(Long id, ProductRequest request) {
        ProductModel productModel = productService.updateProduct(id, request);
        return processResponse(Constants.SUCCESSFULLY_STATUS,Constants.PRODUCT_UPDATED_SUCCESSFULLY, productModel);
            }

    public ResponseEntity<JsonApiResponse> deleteProduct(Long id) {
        ProductModel productModel = productService.deleteProduct(id);
        return processResponse(Constants.SUCCESSFULLY_STATUS,Constants.PRODUCT_DELETED_SUCCESSFULLY, productModel);
    }

    public ResponseEntity<JsonApiListResponse> listProducts(int page, int size) {

        Page<ProductModel> productPage = productService.listProducts(PageRequest.of(page, size));
        return processResponse(Constants.SUCCESSFULLY_STATUS,Constants.PRODUCT_FOUND,page, size, productPage);

    }

    public ResponseEntity<JsonApiResponse> processResponse(String status, String message, ProductModel product){
        JsonApiData<Object> body = JsonApiData.builder()
                .status(status)
                .message(message)
                .attributes(product)
                .build();

        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.ok().body(response);
    }
    public ResponseEntity<JsonApiListResponse> processResponse(String status, String message, int page, int size, Page<ProductModel> productPage){

        JsonApiMeta meta = JsonApiMeta.builder()
                .total(productPage.getTotalElements())
                .page(page)
                .size(size)
                .build();

        JsonApiListResponse dataList = JsonApiListResponse.builder()
                .status(status)
                .message(message)
                .data(productPage.getContent())
                .meta(meta)
                .build();
        return ResponseEntity.ok(dataList);
    }



}
