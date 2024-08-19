package com.demo.kevin.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.kevin.pojo.User;
import com.demo.kevin.pojo.dto.UserDto;
import com.demo.kevin.repository.UserRepository;

@Service  //spring的bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User add(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        //调用数据访问类
        return userRepository.save(userPojo);    
    }
    
    @Override
    public User getUser(Integer userId){
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在，参数异常");
        });
    }

    @Override
    public User edit(UserDto user){
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        
        
        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer userId){
        userRepository.deleteById(userId);
    }
}
