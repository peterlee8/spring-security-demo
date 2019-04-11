package com.limouren.springsecuritydemo.entity;

import lombok.Data;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    private boolean isRemember;

}
