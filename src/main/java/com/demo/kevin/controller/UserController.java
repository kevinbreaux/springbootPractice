package com.demo.kevin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kevin.pojo.ResponseMessage;
import com.demo.kevin.pojo.User;
import com.demo.kevin.pojo.dto.UserDto;
import com.demo.kevin.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController //接口方法返回对象，转换成json文本
@RequestMapping("/user") // localhost:8088/user/**
public class UserController {

    @Autowired
    IUserService userService;

    // REST

    //增加用户
    //@PostMapping //URL: localhost:8088/user, method = post
    @PostMapping
    //String 作为一个返回文本并不合适，但是在这里先无所谓
    //对于mapping的接口，如果是增加单个的话，就不需要指定特殊的接口
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user){
        //System.out.println(user);
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    //增加多个用户
    @PostMapping("/user")
    public ResponseEntity<List<User>> add(@Validated @RequestBody List<UserDto> usersDto){
        List<User> savedUsers = new ArrayList<>();
        for (UserDto userDto : usersDto) {
            User user = userService.add(userDto);  
            savedUsers.add(user);
        }
        return ResponseEntity.ok(savedUsers);  // Return the list of saved users
    }

    /*
     * 查询用户
     * @param userId 
    */
    //@GetMapping
    @GetMapping("/{userId}")
    public ResponseMessage get(@PathVariable Integer userId){
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }
    
    //修改用户
    //@PutMapping
    @PutMapping
    public ResponseMessage edit(@Validated @RequestBody UserDto user){
        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    //删除用户
    //DeleteMapping
    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        userService.delete(userId);
        return ResponseMessage.success();
    }
}
