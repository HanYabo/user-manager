package com.han.usermanager.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {

    //主键id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //用户名
    private String username;

    //昵称
    private String nickname;

    //密码
    private String password;

    //手机号
    private String phone;

    //性别
    private Character sex;

    //描述
    @TableField(value = "`describe`")
    private String describe;

    //创建时间
    @TableField(fill = FieldFill.INSERT) //insert操作时自动注入时间
    private Date gmtCreate;

}
