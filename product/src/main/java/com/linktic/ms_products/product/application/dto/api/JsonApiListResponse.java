package com.linktic.ms_products.product.application.dto.api;

import com.linktic.ms_products.product.domain.model.ProductModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonApiListResponse {
    String status;
    String message;
    List<ProductModel> data;
    JsonApiMeta meta;
}
