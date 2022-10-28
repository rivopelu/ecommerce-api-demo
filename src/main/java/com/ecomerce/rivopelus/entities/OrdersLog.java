package com.ecomerce.rivopelus.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "orders_log")
@Data
public class OrdersLog implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @JoinColumn
    @ManyToOne
    private Orders orders;

    @JoinColumn
    @ManyToOne
    private User user;
    private Integer log_type;
    private String log_message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
}
