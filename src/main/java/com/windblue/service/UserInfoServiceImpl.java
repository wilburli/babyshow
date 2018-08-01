package com.windblue.service;

import com.github.pagehelper.PageHelper;
import com.windblue.mapper.UserInfoMapper;
import com.windblue.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wilburli
 * @Description:
 * @Date: Created by sh on 2018-07-27.
 */
@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;


    public List<UserInfo> getAll(UserInfo userInfo) {
        if (userInfo.getPage() != null && userInfo.getRows() != null) {
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows(), "id");
        }
        return userInfoMapper.selectAll();
    }

    public UserInfo getById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(UserInfo country) {
        if (country.getId() != null) {
            userInfoMapper.updateByPrimaryKey(country);
        } else {
            userInfoMapper.insert(country);
        }
    }
    
}
