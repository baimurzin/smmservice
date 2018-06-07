package com.smm.model;

import com.smm.state.OrderCreatedState;
import com.smm.state.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne
    @JoinColumn(name="service_product_id")
    private ServiceProduct serviceProduct;

    @OneToMany(mappedBy="order")
    private List<Transaction> transactions;

    @Transient
    private OrderState orderState;

    @Column(name = "order_sum")
    private BigDecimal orderSum;

    @Generated(value = GenerationTime.ALWAYS)
    @SequenceGenerator(name = "inv_seq", sequenceName = "inv_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inv_seq")
    @Column(name = "inv_id", unique = true)
    private Integer invId;

    @Column(name = "description")
    private String desc;

    @Column(name = "currency")
    private String currency;

    @Column(name = "email")
    private String email;

    @Column(name = "culture")
    private String culture;
}
