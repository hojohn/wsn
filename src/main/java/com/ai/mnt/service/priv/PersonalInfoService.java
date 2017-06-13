package com.ai.mnt.service.priv;

import java.util.Map;

public interface PersonalInfoService {

    /**
     * 修改密码
     * @param passwd,passwdNew,passwdNew2
     * @return  Map<String, Object>
     */
    public Map<String, Object> updatePersonalPasswd(String passwd, String passwdNew,
            String passwdNew2);

}
