package com.demo.kevin.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseMessage(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //接口请求成功
    public static <T> ResponseMessage<T> success(T data){
        return new ResponseMessage(HttpStatus.OK.value(), "success!", data);
    }   

    public static <T> ResponseMessage success(){
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success!", null);
    }

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public T getData(){
        return data;
    }
    public void setCode(Integer c){
        this.code = c;
    }
    public void setMessage(String msg){
        this.message = msg;
    }
    public void setData(T d){
        this.data = d;
    }
}
