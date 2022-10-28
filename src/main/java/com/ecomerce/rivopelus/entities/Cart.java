package com.ecomerce.rivopelus.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "cart")
@Data
public class Cart implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @JoinColumn
    @ManyToOne
    private Product product;

    @JoinColumn
    @ManyToOne
    private User user;

    private Double quantity;
    private BigDecimal price;
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
}
