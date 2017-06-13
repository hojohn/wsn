package com.ai.mnt.web.priv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.service.priv.PersonalInfoService;
import com.ai.mnt.service.sys.SysRoleService;
import com.ai.mnt.service.sys.SysUserService;


@Controller
@RequestMapping("/priv")
public class PersonalInfoController {

    @Autowired
    SysUserService sysUserService;
    
    @Autowired
    SysRoleService sysRoleService;
    
    @Autowired
    UserRealm userRealm;
    
    @Autowired
    PersonalInfoService personalInfoService;
    
    
    /**
     * 个人资料页面跳转
     * @return
     */
    @RequestMapping("/info/page")
    public String showSysUserPage(Model model) {
        SysUser currentUser = userRealm.getCurrentUser();
        //SysRole sysRole = sysRoleService.findRoleByUserId(currentUser.getUserId());
        //List<EnumObject> baseIdEnums = BaseDataCache.getDataList("BASE_NAME_ENUM");
        List<SysUser>sysUsers = sysUserService.findAllUser();
        model.addAttribute("sysUsers", sysUsers);
       // model.addAttribute("baseIdEnums", baseIdEnums);
        //model.addAttribute("sysRole", sysRole);
        currentUser.setPhoneId(sysUserService.findUserByUserId(currentUser.getUserId()).getPhoneId()); 
        model.addAttribute("currentUser", currentUser);   //yy
        return "priv/info/personal_info";
    }
    

    /**
     * 个人信息修改
     * @return
     */
    @RequestMapping("/info_update")
    @ResponseBody
    public Map<String, Object> updatePrivInfo(/*@RequestParam("file") MultipartFile file,*/ SysUser sysUser,
            HttpServletRequest request) {
       /* if (!file.isEmpty()) {
            try {
                String imgName = file.getOriginalFilename();
                String userAvatarName = sysUser.getUserName() + System.currentTimeMillis() + imgName.substring(imgName.lastIndexOf("."));
                String path = request.getSession().getServletContext().getRealPath("/") + 
                        File.separator + "static" + File.separator + "img" + File.separator + "avatar" + File.separator + userAvatarName;
                File f = new File(path);
                file.transferTo(f);
                sysUser.setUserAvatar(userAvatarName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        sysUserService.updateUser(sysUser);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 密码修改
     * @return
     */
    @RequestMapping("/passwd_update")
    @ResponseBody
    public Map<String, Object> updateUserPasswd(String passwd, String newPasswd, String newPasswd2) {
        Map<String, Object> map = personalInfoService.updatePersonalPasswd(passwd, newPasswd, newPasswd2);
        return map;
    }
}
