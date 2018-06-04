package com.smm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_vendor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVendor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToMany(mappedBy = "paymentVendors")
    private List<Transaction> transactions;
}
