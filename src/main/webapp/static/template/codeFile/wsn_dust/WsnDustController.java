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

import com.ai.mnt.model.sensor.WsnDust;
import com.ai.mnt.service.sensor.WsnDustService;

/**
 * @Title: WsnDustController 
 * @Description: WsnDustController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnDustController {

    @Autowired
    WsnDustService wsnDustService;
    
    /**
     * 粉尘数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnDustPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取粉尘数据表列表
     * @param wsnDust
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnDustList(WsnDust wsnDust) {
        List<WsnDust> wsnDustList = wsnDustService.findWsnDustList(wsnDust);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDustList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 粉尘数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnDustAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 粉尘数据表保存
     * @param wsnDust
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnDust(WsnDust wsnDust) {
        wsnDustService.saveWsnDust(wsnDust);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 粉尘数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnDustUpdatePage(Model model, @PathVariable String id) {
        WsnDust wsnDust = wsnDustService.findWsnDustById(Integer.parseInt(id));
        model.addAttribute("wsnDust", wsnDust);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 粉尘数据表根据主键更新
     * @param wsnDust
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnDust(WsnDust wsnDust) {
        wsnDustService.updateWsnDustById(wsnDust);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 粉尘数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnDustByIds(@PathVariable String ids) {
        wsnDustService.deleteWsnDustByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询粉尘数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnDustById(Model model, @PathVariable String id) {
        WsnDust wsnDust = new WsnDust();
        wsnDust.setId(Integer.parseInt(id));
        List<WsnDust> wsnDustList = wsnDustService.findWsnDustList(wsnDust);
        if(wsnDustList != null && wsnDustList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDust", wsnDustList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
