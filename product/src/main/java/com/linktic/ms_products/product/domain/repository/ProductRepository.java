package com.linktic.ms_products.product.domain.repository;

import com.linktic.ms_products.product.domain.model.ProductModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    ProductModel save(ProductModel product);

    Optional<ProductModel> findById(Long id);

    Page<ProductModel> findAll(Pageable pageable);

    void deleteById(Long id);
}
