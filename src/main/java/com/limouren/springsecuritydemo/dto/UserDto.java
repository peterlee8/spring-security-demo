package com.limouren.springsecuritydemo.dto;

import lombok.Data;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@Data
public class UserDto {

    private Integer id;

    private String username;

    private String pwd;

    private String role;
}
