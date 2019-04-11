package com.limouren.springsecuritydemo.controller;

import com.limouren.springsecuritydemo.dto.UserDto;
import com.limouren.springsecuritydemo.entity.User;
import com.limouren.springsecuritydemo.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     private UserDtoMapper userDtoMapper;

     @PostMapping("/userDto")
     public void getUser(@RequestBody UserDto userDto) {
        User user = userDtoMapper.toEntity(userDto);
        System.out.println(user);
     }

     @PostMapping("/user")
     public UserDto getUserDto(@RequestBody User user) {
         return userDtoMapper.toDto(user);
     }
}
