package com.ai.mnt.web.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.device.WsnGeteway;
import com.ai.mnt.service.device.WsnGetewayService;

/**
 * @Title: WsnGetewayController 
 * @Description: WsnGetewayController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

@Controller
@RequestMapping("/device")
public class WsnGetewayController {

    @Autowired
    WsnGetewayService wsnGetewayService;
    
    /**
     * 网关表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/geteway/page")
    public String showWsnGetewayPage(Model model) {
        return "device/geteway/device_geteway_query";
    }
    
    /**
     * 获取网关表列表
     * @param wsnGeteway
     * @return Map<String, Object>
     */
    @RequestMapping("/geteway/query")
    @ResponseBody
    public Map<String, Object> getWsnGetewayList(WsnGeteway wsnGeteway) {
        List<WsnGeteway> wsnGetewayList = wsnGetewayService.findWsnGetewayList(wsnGeteway);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnGetewayList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 网关表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/geteway/add_page")
    public String showWsnGetewayAddPage(Model model) {
        return "device/geteway/device_geteway_add";
    }
    
    /**
     * 网关表保存
     * @param wsnGeteway
     * @return Map<String, Object>
     */
    @RequestMapping("/geteway/add")
    @ResponseBody
    public Map<String, Object> saveWsnGeteway(WsnGeteway wsnGeteway) {
        wsnGetewayService.saveWsnGeteway(wsnGeteway);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 网关表更新界面跳转
     * @param  model
     * @param  gatewayId
     * @return
     */
    @RequestMapping("/geteway/update_page/{gatewayId}")
    public String showWsnGetewayUpdatePage(Model model, @PathVariable String gatewayId) {
        WsnGeteway wsnGeteway = wsnGetewayService.findWsnGetewayByGatewayId(Integer.parseInt(gatewayId));
        model.addAttribute("wsnGeteway", wsnGeteway);
        return "device/geteway/device_geteway_update";
    }
    
    /**
     * 网关表根据主键更新
     * @param wsnGeteway
     * @return
     */
    @RequestMapping("/geteway/update")
    @ResponseBody
    public Map<String, Object> updateWsnGeteway(WsnGeteway wsnGeteway) {
        wsnGetewayService.updateWsnGetewayByGatewayId(wsnGeteway);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 网关表根据主键批量删除
     * @param gatewayIds
     * @return Map<String, Object>
     */
    @RequestMapping("/geteway/delete/{gatewayIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnGetewayByGatewayIds(@PathVariable String gatewayIds) {
        wsnGetewayService.deleteWsnGetewayByGatewayIds(gatewayIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询网关表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/geteway/{gatewayId}/page")
    public String queryWsnGetewayByGatewayId(Model model, @PathVariable String gatewayId) {
        WsnGeteway wsnGeteway = new WsnGeteway();
        wsnGeteway.setGatewayId(Integer.parseInt(gatewayId));
        List<WsnGeteway> wsnGetewayList = wsnGetewayService.findWsnGetewayList(wsnGeteway);
        if(wsnGetewayList != null && wsnGetewayList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnGeteway", wsnGetewayList.get(0));
        }
        return "device/geteway/device_geteway_info";
    }
}
