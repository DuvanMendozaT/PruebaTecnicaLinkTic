package com.linktic.ms_inventory.inventory.infrastructure.adapter.oracledb;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "TBL_INVENTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_ID_INVENTORY")
    private Long id;

    @Column(name = "NUM_PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "NUM_QUANTITY", nullable = false)
    private Integer quantity;
}