package com.nax.repository;

import com.nax.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Maxim on 9/23/2017.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Iterable <UserEntity> findByPhone (String phone);
    UserEntity findOneByPhone(String phone);
    UserEntity findByPhoneAndPassword(String phone, String password);
    UserEntity findOneByPhoneAndPassword(String phone, String password);
    UserEntity findOneByPhoneAndRate(String phone, String password);
    UserEntity findOneByPhoneAndStatus(String phone, String status);
}

