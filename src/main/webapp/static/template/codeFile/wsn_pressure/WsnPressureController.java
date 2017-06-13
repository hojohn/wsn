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

import com.ai.mnt.model.sensor.WsnPressure;
import com.ai.mnt.service.sensor.WsnPressureService;

/**
 * @Title: WsnPressureController 
 * @Description: WsnPressureController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnPressureController {

    @Autowired
    WsnPressureService wsnPressureService;
    
    /**
     * 压力数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnPressurePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取压力数据表列表
     * @param wsnPressure
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnPressureList(WsnPressure wsnPressure) {
        List<WsnPressure> wsnPressureList = wsnPressureService.findWsnPressureList(wsnPressure);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnPressureList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 压力数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnPressureAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 压力数据表保存
     * @param wsnPressure
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnPressure(WsnPressure wsnPressure) {
        wsnPressureService.saveWsnPressure(wsnPressure);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 压力数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnPressureUpdatePage(Model model, @PathVariable String id) {
        WsnPressure wsnPressure = wsnPressureService.findWsnPressureById(Integer.parseInt(id));
        model.addAttribute("wsnPressure", wsnPressure);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 压力数据表根据主键更新
     * @param wsnPressure
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnPressure(WsnPressure wsnPressure) {
        wsnPressureService.updateWsnPressureById(wsnPressure);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 压力数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnPressureByIds(@PathVariable String ids) {
        wsnPressureService.deleteWsnPressureByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询压力数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnPressureById(Model model, @PathVariable String id) {
        WsnPressure wsnPressure = new WsnPressure();
        wsnPressure.setId(Integer.parseInt(id));
        List<WsnPressure> wsnPressureList = wsnPressureService.findWsnPressureList(wsnPressure);
        if(wsnPressureList != null && wsnPressureList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnPressure", wsnPressureList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
