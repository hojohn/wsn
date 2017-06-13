package com.ai.mnt.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: User 
 * @Description: User Model
 * @Author: Auto Generate.
 * @Date: 2016-12-12
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    /**名字*/
    private String username;

    /**密码*/
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}