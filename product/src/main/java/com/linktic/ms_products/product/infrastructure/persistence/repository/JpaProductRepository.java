package com.linktic.ms_products.product.infrastructure.persistence.repository;

import com.linktic.ms_products.product.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity,Long> {
}
