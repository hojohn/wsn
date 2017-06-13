package com.ai.mnt.service.user.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.user.User;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.user.UserMapper;
import com.ai.mnt.service.user.UserService;

/**
 * @Title: UserServiceImpl 
 * @Description: UserServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-12
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有用户表列表
     * @return List<User>
     */
    @Override
    public List<User> findAllUser() {
        List<User> userList = userMapper.findAll();
        //cvtContentList(userList);
        return userList;
    }

    /**
     * 获取用户表列表
     * @param user
     * @return List<User>
     */
    @Override
    public List<User> findUserList(User user) {
        List<User> userList = userMapper.findList(user);
        //cvtContentList(userList);
        return userList;
    }

    /**
     * 通过主键ID获取用户表
     * @param username Primary key
     * @return User
     */
    @Override
    public User findUserByUsername(Integer username) {
        User user = userMapper.findByPrimaryKey(username);
        return user;
    }

    /**
     * 添加用户表
     * @param User
     */
    @Override
    public void saveUser(User user) {
        SysUser currentUser = userRealm.getCurrentUser();
        user.setDeleteFlag("0");
        user.setCreator(currentUser.getUserName());
        user.setModifier(currentUser.getUserName());
        user.setCreateDate(new Date());
        user.setModifyDate(new Date());
        userMapper.save(user);
        
    }

    /**
     * 更新用户表
     * 根据User的主键更新主键以外的其他字段
     * @param User
     */
    @Override
    public void updateUserByUsername(User user) {
        SysUser currentUser = userRealm.getCurrentUser();
        user.setModifier(currentUser.getUserName());
        user.setModifyDate(new Date());
        userMapper.updateByPrimaryKey(user);
        
    }

    /**
     * 根据主键批量删除用户表 
     * 非物理删除 修改删除标识
     * @param username Primary key
     */
    @Override
    public void deleteUserByUsernames(String usernames) {
        SysUser currentUser = userRealm.getCurrentUser();
        User user = new User();
        user.setDeleteFlag("1");
        user.setModifier(currentUser.getUserName());
        user.setModifyDate(new Date());
        String[] usernameAry = usernames.split(",");
        for(String username : usernameAry) {
            user.setUsername(Integer.parseInt(username));
            userMapper.updateByPrimaryKey(user);
        }
    }
    
    //private void cvtContentList(List<User> UserList) {
    //    for(User user : UserList) {
    //    }
    //}
}

