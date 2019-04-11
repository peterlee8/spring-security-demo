package com.limouren.springsecuritydemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@Data
@Entity
@Table(name = "jd_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
