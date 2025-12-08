package com.linktic.ms_inventory.inventory.domain.port;

import com.linktic.ms_inventory.inventory.domain.model.ProductModel;

public interface ExternalProductApiPort {
    ProductModel getProductDetails(Long externalId,String apiKey);

}
