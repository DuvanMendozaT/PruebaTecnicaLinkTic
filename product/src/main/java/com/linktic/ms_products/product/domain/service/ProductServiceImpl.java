package com.linktic.ms_products.product.domain.service;

import com.linktic.ms_products.product.application.Constants;
import com.linktic.ms_products.product.application.dto.api.ProductRequest;
import com.linktic.ms_products.product.domain.exeption.ProductNotFoundException;
import com.linktic.ms_products.product.domain.model.ProductModel;
import com.linktic.ms_products.product.domain.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductModel createProduct(ProductRequest productRequest) {

        ProductModel productModel = ProductModel.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();

        return productRepository.save(productModel);
    }

    @Override
    public ProductModel getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND));
    }

    @Override
    public ProductModel updateProduct(Long id, ProductRequest request) {
        ProductModel existing = getById(id);

        existing.setName(request.getName());
        existing.setPrice(request.getPrice());

        return productRepository.save(existing);
    }

    @Override
    public ProductModel deleteProduct(Long id) {
        ProductModel existing = getById(id);
        productRepository.deleteById(id);

        return existing;
    }

    @Override
    public Page<ProductModel> listProducts(Pageable pageable) {

        return productRepository.findAll(pageable);
    }
}
