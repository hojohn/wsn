package com.ai.mnt.web.sensor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.sensor.WsnSmoke;
import com.ai.mnt.service.sensor.WsnSmokeService;

/**
 * @Title: WsnSmokeController 
 * @Description: WsnSmokeController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnSmokeController {

    @Autowired
    WsnSmokeService wsnSmokeService;
    
    /**
     * 烟雾数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnSmokePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取烟雾数据表列表
     * @param wsnSmoke
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnSmokeList(WsnSmoke wsnSmoke) {
        List<WsnSmoke> wsnSmokeList = wsnSmokeService.findWsnSmokeList(wsnSmoke);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnSmokeList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 烟雾数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnSmokeAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 烟雾数据表保存
     * @param wsnSmoke
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnSmoke(WsnSmoke wsnSmoke) {
        wsnSmokeService.saveWsnSmoke(wsnSmoke);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 烟雾数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnSmokeUpdatePage(Model model, @PathVariable String id) {
        WsnSmoke wsnSmoke = wsnSmokeService.findWsnSmokeById(Integer.parseInt(id));
        model.addAttribute("wsnSmoke", wsnSmoke);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 烟雾数据表根据主键更新
     * @param wsnSmoke
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnSmoke(WsnSmoke wsnSmoke) {
        wsnSmokeService.updateWsnSmokeById(wsnSmoke);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 烟雾数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnSmokeByIds(@PathVariable String ids) {
        wsnSmokeService.deleteWsnSmokeByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询烟雾数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnSmokeById(Model model, @PathVariable String id) {
        WsnSmoke wsnSmoke = new WsnSmoke();
        wsnSmoke.setId(Integer.parseInt(id));
        List<WsnSmoke> wsnSmokeList = wsnSmokeService.findWsnSmokeList(wsnSmoke);
        if(wsnSmokeList != null && wsnSmokeList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnSmoke", wsnSmokeList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
