package com.demo.kevin.pojo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private Integer userId;
    @NotBlank(message = "用户名不能为空") //去除空格
    //@NotEmpty
    private String userName;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 24)
    private String password;
    @Email(message = "email格式不正确")
    private String email;
    
    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "User{"  +
        "username='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email +'\'' + '}';
    }
}
