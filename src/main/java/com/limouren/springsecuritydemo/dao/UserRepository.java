package com.limouren.springsecuritydemo.dao;

import com.limouren.springsecuritydemo.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
