package com.jianyuyouhun.typechoapi.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<UserInfo, Integer> {
    @Override
    Optional<UserInfo> findById(Integer integer);

    @Override
    Iterable<UserInfo> findAll();

    UserInfo findByUserName(String userName);

    UserInfo findByAuthCode(String authCode);
}
