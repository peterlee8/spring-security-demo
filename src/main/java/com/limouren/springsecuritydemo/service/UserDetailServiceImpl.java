package com.limouren.springsecuritydemo.service;

import com.limouren.springsecuritydemo.dao.UserRepository;
import com.limouren.springsecuritydemo.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new JwtUser(userRepository.findByUsername(s));
    }

}
