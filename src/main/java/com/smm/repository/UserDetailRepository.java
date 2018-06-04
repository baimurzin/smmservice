package com.smm.repository;

import com.smm.model.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, String> {

    UserDetail getByReferCode(String referCode);
}
