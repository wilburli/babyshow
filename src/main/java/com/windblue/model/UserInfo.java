package com.windblue.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wilburli
 * @Description: 用户表
 * @Date: Created by sh on 2018-07-27.
 */
@Data
public class UserInfo extends BaseEntity {

//    private String uuId; // 小程序和用户关联id

    private String username;

//    private Date createTime;  // 初次登录
//
//    private Date updateTime; // 最近一次登录

    private String password;
    private String usertype;
    private Integer enabled;
    private String qq;
    private String email;
    private String tel;






}
