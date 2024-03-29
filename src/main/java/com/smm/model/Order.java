package com.smm.model;

import com.smm.state.OrderCreatedState;
import com.smm.state.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
}
