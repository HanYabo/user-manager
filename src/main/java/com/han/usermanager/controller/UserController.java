package com.han.usermanager.controller;


import com.han.usermanager.pojo.User;
import com.han.usermanager.service.UserService;
import com.han.usermanager.vo.QueryParam;
import com.han.usermanager.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping("")
    public Status insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    //删除单个用户
    @DeleteMapping("{id}")
    public Status deleteUser(@PathVariable(value = "id") Integer id){
        return userService.deleteUser(id);
    }

    //删除多个用户
    @DeleteMapping("")
    public Status deleteMoreUsers(@RequestBody List<Integer> ids){
        return userService.deleteMoreUsers(ids);
    }

    //编辑用户
    @PutMapping("")
    public Status modifyUser(@RequestBody User user){
        return userService.modifyUser(user);
    }

    //查询用户列表
    @PostMapping("{index}/{size}")
    public Status findUserList(@PathVariable(value = "index") Integer index,
                               @PathVariable(value = "size") Integer size,
                               @RequestBody(required = false)QueryParam queryParam){
        return userService.findUserList(index,size,queryParam);
    }

    //根据用户编号查询用户信息
    @PostMapping("{id}")
    public Status getUserInfo(@PathVariable(value = "id") Integer id){
        return userService.getUserInfoById(id);
    }
}
