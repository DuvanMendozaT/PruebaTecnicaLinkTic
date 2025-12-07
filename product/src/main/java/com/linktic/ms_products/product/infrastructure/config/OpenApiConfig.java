package com.linktic.ms_products.product.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Products Service API",
                version = "1.0",
                description = "API para gestión de productos (creación, consulta, actualización y eliminación)"
        )
)
public class OpenApiConfig {
}
