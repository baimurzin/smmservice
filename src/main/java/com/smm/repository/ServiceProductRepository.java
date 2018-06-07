package com.smm.repository;

import com.smm.model.Service;
import com.smm.model.ServiceProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceProductRepository extends CrudRepository<ServiceProduct, String> {

    @Query(value = "TRUNCATE TABLE service_product CASCADE", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}
