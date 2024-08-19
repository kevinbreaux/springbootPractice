package com.demo.kevin.service;


import com.demo.kevin.pojo.User;
import com.demo.kevin.pojo.dto.UserDto;

public interface IUserService {
    /*
        插入用户
        @param user
    */
    User add(UserDto user);
    User getUser(Integer userId);
    User edit(UserDto user);
    void delete(Integer userId);
}
