package com.linktic.ms_products.product.infrastructure.persistence.adapter;

import com.linktic.ms_products.product.domain.model.ProductModel;
import com.linktic.ms_products.product.domain.repository.ProductRepository;
import com.linktic.ms_products.product.infrastructure.persistence.mapper.ProductPersistenceMapper;
import com.linktic.ms_products.product.infrastructure.persistence.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Autowired
    private ProductPersistenceMapper mapper;

    @Override
    public ProductModel save(ProductModel product) {
        return mapper.toDomain(jpaProductRepository.save(mapper.toEntity(product)));
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Page<ProductModel> findAll(Pageable pageable) {
        return mapper.toDomainList(jpaProductRepository.findAll(pageable));
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }
}
