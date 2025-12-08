package com.linktic.ms_inventory.inventory.infrastructure.persistence.mapper;

import com.linktic.ms_inventory.inventory.domain.model.InventoryModel;
import com.linktic.ms_inventory.inventory.infrastructure.persistence.entity.InventoryEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface InventoryPersistenceMapper {
    InventoryEntity toEntity(InventoryModel domain);

    InventoryModel toDomain(InventoryEntity entity);

}
