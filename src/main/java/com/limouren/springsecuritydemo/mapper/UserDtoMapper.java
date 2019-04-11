package com.limouren.springsecuritydemo.mapper;

import com.limouren.springsecuritydemo.dto.UserDto;
import com.limouren.springsecuritydemo.entity.User;
import org.mapstruct.*;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
@Mapper(componentModel="spring")
public interface UserDtoMapper extends EntityMapper<UserDto,User> {

}
