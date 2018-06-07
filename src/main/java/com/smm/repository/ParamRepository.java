package com.smm.repository;

import com.smm.model.Param;
import com.smm.model.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ParamRepository extends CrudRepository<Param, String> {

    @Query(value = "TRUNCATE TABLE param CASCADE", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}
