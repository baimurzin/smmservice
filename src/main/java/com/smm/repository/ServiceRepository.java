package com.smm.repository;

import com.smm.model.Service;
import com.smm.model.UserDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

    @Query(value = "TRUNCATE TABLE service CASCADE", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}
