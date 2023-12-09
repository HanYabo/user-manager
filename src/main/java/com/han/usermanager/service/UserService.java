package com.han.usermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.han.usermanager.pojo.User;
import com.han.usermanager.vo.QueryParam;
import com.han.usermanager.vo.Status;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 添加用户
     * @param user
     * @return
     */
    Status insertUser(User user);

    /**
     * 删除单个用户
     * @param id 用户编号
     * @return
     */
    Status deleteUser(Integer id);

    /**
     * 删除多个用户
     * @param ids 用户编号集合
     * @return
     */
    Status deleteMoreUsers(List<Integer> ids);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    Status modifyUser(User user);

    /**
     * 分页查询用户列表
     * @param index
     * @param size
     * @param queryParam
     * @return
     */
     Status findUserList(Integer index, Integer size, QueryParam queryParam);

    /**
     * 查询单个用户详细信息
     * @param id
     * @return
     */
     Status getUserInfoById(Integer id);

}