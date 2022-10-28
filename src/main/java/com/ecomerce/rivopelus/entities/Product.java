package com.ecomerce.rivopelus.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "products")
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
    private Double stock;

    @JoinColumn
    @ManyToOne
    private Category category;
}
