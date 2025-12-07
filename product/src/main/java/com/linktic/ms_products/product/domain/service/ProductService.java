package com.linktic.ms_products.product.domain.service;

import com.linktic.ms_products.product.application.dto.api.ProductRequest;
import com.linktic.ms_products.product.domain.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    ProductModel createProduct(ProductRequest productRequest);

    ProductModel getById(Long id);

    ProductModel updateProduct(Long id, ProductRequest request);

    ProductModel deleteProduct(Long id);

    Page<ProductModel> listProducts(Pageable pageable);

}
