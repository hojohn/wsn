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

import com.ai.mnt.model.sensor.WsnCarbondioxide;
import com.ai.mnt.service.sensor.WsnCarbondioxideService;

/**
 * @Title: WsnCarbondioxideController 
 * @Description: WsnCarbondioxideController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnCarbondioxideController {

    @Autowired
    WsnCarbondioxideService wsnCarbondioxideService;
    
    /**
     * 二氧化碳数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnCarbondioxidePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取二氧化碳数据表列表
     * @param wsnCarbondioxide
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnCarbondioxideList(WsnCarbondioxide wsnCarbondioxide) {
        List<WsnCarbondioxide> wsnCarbondioxideList = wsnCarbondioxideService.findWsnCarbondioxideList(wsnCarbondioxide);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnCarbondioxideList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 二氧化碳数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnCarbondioxideAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 二氧化碳数据表保存
     * @param wsnCarbondioxide
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnCarbondioxide(WsnCarbondioxide wsnCarbondioxide) {
        wsnCarbondioxideService.saveWsnCarbondioxide(wsnCarbondioxide);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 二氧化碳数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnCarbondioxideUpdatePage(Model model, @PathVariable String id) {
        WsnCarbondioxide wsnCarbondioxide = wsnCarbondioxideService.findWsnCarbondioxideById(Integer.parseInt(id));
        model.addAttribute("wsnCarbondioxide", wsnCarbondioxide);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 二氧化碳数据表根据主键更新
     * @param wsnCarbondioxide
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnCarbondioxide(WsnCarbondioxide wsnCarbondioxide) {
        wsnCarbondioxideService.updateWsnCarbondioxideById(wsnCarbondioxide);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 二氧化碳数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnCarbondioxideByIds(@PathVariable String ids) {
        wsnCarbondioxideService.deleteWsnCarbondioxideByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询二氧化碳数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnCarbondioxideById(Model model, @PathVariable String id) {
        WsnCarbondioxide wsnCarbondioxide = new WsnCarbondioxide();
        wsnCarbondioxide.setId(Integer.parseInt(id));
        List<WsnCarbondioxide> wsnCarbondioxideList = wsnCarbondioxideService.findWsnCarbondioxideList(wsnCarbondioxide);
        if(wsnCarbondioxideList != null && wsnCarbondioxideList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnCarbondioxide", wsnCarbondioxideList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
