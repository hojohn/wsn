package com.ai.mnt.persistence.user;


import org.springframework.stereotype.Repository;

import com.ai.mnt.model.user.User;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: UserMapper 
 * @Description: UserMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-12-12
 */
@Repository
public interface UserMapper extends CrudMapper<User, String>{
    
    
}