package com.han.usermanager;

import com.han.usermanager.mapper.UserMapper;
import com.han.usermanager.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class UserManagerApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser(){
        User user = new User(1,"infinity","韩亚博","123456","13613736311",'男',"无",new Date());
        userMapper.insert(user);
    }

}
