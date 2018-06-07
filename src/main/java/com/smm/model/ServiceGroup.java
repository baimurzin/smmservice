package com.smm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "service_group")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceGroup {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToMany(mappedBy="serviceGroup")
    private List<Service> serviceList;

    @Column(name = "name")
    private String name;
}
