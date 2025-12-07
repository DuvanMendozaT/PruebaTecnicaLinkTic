package com.linktic.ms_products.product.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductRequest {

    @JsonProperty("Name")
    @NotBlank
    String name;

    @JsonProperty("Price")
    @NotNull
    @Min(0)
    BigDecimal price;
}
