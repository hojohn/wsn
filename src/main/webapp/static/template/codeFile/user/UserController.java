package com.ai.mnt.web.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.user.User;
import com.ai.mnt.service.user.UserService;

/**
 * @Title: UserController 
 * @Description: UserController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-12
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    /**
     * 用户表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showUserPage(Model model) {
        return "user/info/user_info_query";
    }
    
    /**
     * 获取用户表列表
     * @param user
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getUserList(User user) {
        List<User> userList = userService.findUserList(user);
        Map<String, Object> map = new HashMap<>();
        map.put("data", userList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 用户表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showUserAddPage(Model model) {
        return "user/info/user_info_add";
    }
    
    /**
     * 用户表保存
     * @param user
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveUser(User user) {
        userService.saveUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 用户表更新界面跳转
     * @param  model
     * @param  username
     * @return
     */
    @RequestMapping("/info/update_page/{username}")
    public String showUserUpdatePage(Model model, @PathVariable String username) {
        User user = userService.findUserByUsername(Integer.parseInt(username));
        model.addAttribute("user", user);
        return "user/info/user_info_update";
    }
    
    /**
     * 用户表根据主键更新
     * @param user
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateUser(User user) {
        userService.updateUserByUsername(user);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 用户表根据主键批量删除
     * @param usernames
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{usernames}")
    @ResponseBody
    public Map<String, Object> deleteUserByUsernames(@PathVariable String usernames) {
        userService.deleteUserByUsernames(usernames);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询用户表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{username}/page")
    public String queryUserByUsername(Model model, @PathVariable String username) {
        User user = new User();
        user.setUsername(Integer.parseInt(username));
        List<User> userList = userService.findUserList(user);
        if(userList != null && userList.size() > 0) { //只会有一条数据
            model.addAttribute("user", userList.get(0));
        }
        return "user/info/user_info_info";
    }
}
