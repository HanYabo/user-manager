package com.han.usermanager.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Status {
    private Boolean success;
    private Integer code;
    private String message;

    private Map<String,Object> data = new HashMap<>();

    private Status(){

    }

    //成功静态方法
    public static Status ok(){
        Status status = new Status();
        status.setSuccess(true);
        status.setCode(200);
        status.setMessage("成功");
        return status;
    }

    //失败静态方法
    public static Status error(){
        Status status = new Status();
        status.setSuccess(false);
        status.setCode(201);
        status.setMessage("失败");
        return status;
    }

    public Status success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Status message(String message){
        this.setMessage(message);
        return this;
    }

    public Status code(Integer code){
        this.setCode(code);
        return this;
    }

    public Status data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}
