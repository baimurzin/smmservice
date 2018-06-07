package com.smm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "param")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Param {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "param_name")
    private String paramName;
    @Column(name = "name")
    private String name;
    @Column(name = "validation_rule")
    private String validationRule;
    @Column(name = "required")
    private Integer required;

    @ManyToOne
    @JoinColumn(name = "service_product_id")
    private ServiceProduct serviceProduct;
}
