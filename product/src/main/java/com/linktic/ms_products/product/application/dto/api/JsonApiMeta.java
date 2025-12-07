package com.linktic.ms_products.product.application.dto.api;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonApiMeta {
    int page;
    int size;
    long total;
}
