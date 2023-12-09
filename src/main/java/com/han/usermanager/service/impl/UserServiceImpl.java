package com.han.usermanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.han.usermanager.mapper.UserMapper;
import com.han.usermanager.pojo.User;
import com.han.usermanager.service.UserService;
import com.han.usermanager.vo.QueryParam;
import com.han.usermanager.vo.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public Status insertUser(User user) {
        if(user == null) Status.error().message("参数错误！");

        //读取用户名
        String username = user.getUsername();

        //构造条件对象，查询是否已经存在用户名
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id");
        wrapper.eq("username",username);
        wrapper.last("limit 1");

        //查询判断，如果查询出来有数据，则不为null
        if(this.baseMapper.selectOne(wrapper) != null) Status.error().message("该用户名已存在！");

        //执行插入数据操作
        return this.baseMapper.insert(user) == 0 ? Status.error().message("添加用户失败！") : Status.ok();
    }

    @Override
    public Status deleteUser(Integer id) {
        if(id == null || id <= 0) Status.error().message("参数错误！");

        return this.baseMapper.deleteById(id) == 0 ? Status.error().message("删除失败！") : Status.ok();
    }

    @Override
    public Status deleteMoreUsers(List<Integer> ids) {
        if(ids.size() == 0) Status.error().message("参数错误！");

        return this.baseMapper.deleteBatchIds(ids) != ids.size() ? Status.error().message("删除失败！") : Status.ok();
    }

    @Override
    public Status modifyUser(User user) {
        if(user == null || user.getId() == null || user.getId() <= 0) Status.error().message("参数错误！");

        return this.baseMapper.updateById(user) == 0 ? Status.error().message("编辑用户失败！") : Status.ok();
    }

    @Override
    public Status findUserList(Integer index, Integer size, QueryParam queryParam) {
        if (index == null || size == null || index <= 0 || size <= 0) {
            return Status.error().message("参数错误！");
        } else if (size > 10) {
            return Status.error().message("一次最多10条数据！");
        }

        //构建分页对象
        Page<User> page = new Page<>(index,size);
        //查询
        IPage<User> iPage = this.baseMapper.findUserList(page,queryParam);

        //回传两个数据，一个userList,一个total
        return Status.ok().data("userList",iPage.getRecords()).data("total",iPage.getTotal());
    }

    @Override
    public Status getUserInfoById(Integer id) {
        if(id == null || id <= 0) Status.error().message("参数错误！");

        return Status.ok().data("userInfo",this.baseMapper.selectById(id));
    }
}
