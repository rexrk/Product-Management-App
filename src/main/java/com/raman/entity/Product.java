package com.raman.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "increment")
    private Integer productId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "supplier_id", nullable = false)
    private Integer supplierId;
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Column(name = "quantity_per_unit", nullable = false)
    private String quantityPerUnit;
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;
    @Column(name = "units_in_stock", nullable = false)
    private Integer unitsInStock;
    @Column(name = "units_on_order", nullable = false)
    private Integer unitsOnOrder;
    @Column(name = "reorder_level", nullable = false)
    private Integer reorderLevel;
    private Integer discontinued;
}
