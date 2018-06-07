package com.smm.repository;

import com.smm.model.Service;
import com.smm.model.ServiceGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceGroupRepository extends CrudRepository<ServiceGroup, String> {

    @Query(value = "TRUNCATE TABLE service_group CASCADE", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}
