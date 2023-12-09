package com.han.usermanager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.han.usermanager.pojo.User;
import com.han.usermanager.vo.QueryParam;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * @param page 分页对象
     * @param queryParam 查询条件
     * @return
     */
    IPage<User> findUserList(Page<User> page, QueryParam queryParam);
}
