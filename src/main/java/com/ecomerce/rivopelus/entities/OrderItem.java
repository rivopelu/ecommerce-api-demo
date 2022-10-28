package com.ecomerce.rivopelus.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "order_item")
@Data
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @JoinColumn
    @ManyToOne
    private Product product;

    private String description;
    private Double quantity;
    private BigDecimal unit_price;
    private BigDecimal items_amount;
}
