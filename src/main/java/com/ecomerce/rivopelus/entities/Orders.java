package com.ecomerce.rivopelus.entities;

import com.ecomerce.rivopelus.entities.model.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "orders")
@Data
public class Orders implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String order_number;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JoinColumn
    @ManyToOne
    private User user_id;
    private String shipping_address;
    private BigDecimal amount_orders;
    private BigDecimal shipping_price;
    private BigDecimal total_orders;

    @Enumerated(EnumType.STRING)
    private OrderStatus status_orders;

    @Temporal(TemporalType.TIMESTAMP)
    private Date order_time;
}
