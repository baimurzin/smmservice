package com.smm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "service_group")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceGroup {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToMany(mappedBy="serviceGroup")
    private List<Service> serviceList;
}
