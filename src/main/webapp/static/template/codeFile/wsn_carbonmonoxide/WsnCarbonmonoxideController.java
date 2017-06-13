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

import com.ai.mnt.model.sensor.WsnCarbonmonoxide;
import com.ai.mnt.service.sensor.WsnCarbonmonoxideService;

/**
 * @Title: WsnCarbonmonoxideController 
 * @Description: WsnCarbonmonoxideController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnCarbonmonoxideController {

    @Autowired
    WsnCarbonmonoxideService wsnCarbonmonoxideService;
    
    /**
     * 一氧化碳数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnCarbonmonoxidePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取一氧化碳数据表列表
     * @param wsnCarbonmonoxide
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnCarbonmonoxideList(WsnCarbonmonoxide wsnCarbonmonoxide) {
        List<WsnCarbonmonoxide> wsnCarbonmonoxideList = wsnCarbonmonoxideService.findWsnCarbonmonoxideList(wsnCarbonmonoxide);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnCarbonmonoxideList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 一氧化碳数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnCarbonmonoxideAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 一氧化碳数据表保存
     * @param wsnCarbonmonoxide
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnCarbonmonoxide(WsnCarbonmonoxide wsnCarbonmonoxide) {
        wsnCarbonmonoxideService.saveWsnCarbonmonoxide(wsnCarbonmonoxide);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 一氧化碳数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnCarbonmonoxideUpdatePage(Model model, @PathVariable String id) {
        WsnCarbonmonoxide wsnCarbonmonoxide = wsnCarbonmonoxideService.findWsnCarbonmonoxideById(Integer.parseInt(id));
        model.addAttribute("wsnCarbonmonoxide", wsnCarbonmonoxide);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 一氧化碳数据表根据主键更新
     * @param wsnCarbonmonoxide
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnCarbonmonoxide(WsnCarbonmonoxide wsnCarbonmonoxide) {
        wsnCarbonmonoxideService.updateWsnCarbonmonoxideById(wsnCarbonmonoxide);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 一氧化碳数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnCarbonmonoxideByIds(@PathVariable String ids) {
        wsnCarbonmonoxideService.deleteWsnCarbonmonoxideByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询一氧化碳数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnCarbonmonoxideById(Model model, @PathVariable String id) {
        WsnCarbonmonoxide wsnCarbonmonoxide = new WsnCarbonmonoxide();
        wsnCarbonmonoxide.setId(Integer.parseInt(id));
        List<WsnCarbonmonoxide> wsnCarbonmonoxideList = wsnCarbonmonoxideService.findWsnCarbonmonoxideList(wsnCarbonmonoxide);
        if(wsnCarbonmonoxideList != null && wsnCarbonmonoxideList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnCarbonmonoxide", wsnCarbonmonoxideList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
