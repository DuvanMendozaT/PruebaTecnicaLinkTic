package com.linktic.ms_inventory.inventory.infrastructure.persistence.repository;

import com.linktic.ms_inventory.inventory.infrastructure.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInventoryRepository extends JpaRepository<InventoryEntity, Long> {
}
