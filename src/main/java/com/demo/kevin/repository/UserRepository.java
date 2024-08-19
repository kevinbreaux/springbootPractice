package com.demo.kevin.repository;

import com.demo.kevin.pojo.User;
import com.demo.kevin.pojo.dto.UserDto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //bean
//用Service表示业务逻辑的bean，repository表示数据访问类的bean
public interface UserRepository extends CrudRepository<User, Integer>{

    User save(UserDto user);
    
}
