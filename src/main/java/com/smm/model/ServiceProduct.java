package com.smm.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "service_product")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "api_service_id")
    private String apiServiceId;

    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service;

    @OneToMany(mappedBy="serviceProduct")
    private List<Bonus> bonuses;

    @OneToMany(mappedBy="serviceProduct")
    private List<Order> orders;

    @OneToMany(mappedBy="serviceProduct")
    private List<Param> params;
}
