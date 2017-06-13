package com.ai.mnt.service.user;

import java.util.List;
import com.ai.mnt.model.user.User;

/**
 * @Title: UserService 
 * @Description: UserService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-12
 */

public interface UserService {
    
    /**
     * 获取所有用户表列表
     * @return List<User>
     */
    public List<User> findAllUser();
    
    
    /**
     * 获取用户表列表
     * @param user
     * @return List<User>
     */
    public List<User> findUserList(User user);
    
    /**
     * 通过主键ID获取用户表
     * @param username Primary key
     * @return User
     */
    public User findUserByUsername(Integer username);
    
    /**
     * 添加用户表
     * @param User
     */
    public void saveUser(User user);
    
    /**
     * 更新用户表
     * 根据User的主键更新主键以外的其他字段
     * @param User
     */
    public void updateUserByUsername(User user);
    
    /**
     * 根据主键批量删除用户表 
     * 非物理删除 修改删除标识
     * @param username Primary key
     */
    public void deleteUserByUsernames(String usernames);
}
