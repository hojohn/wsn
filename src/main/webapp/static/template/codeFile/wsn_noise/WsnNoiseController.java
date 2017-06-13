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

import com.ai.mnt.model.sensor.WsnNoise;
import com.ai.mnt.service.sensor.WsnNoiseService;

/**
 * @Title: WsnNoiseController 
 * @Description: WsnNoiseController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

@Controller
@RequestMapping("/sensor")
public class WsnNoiseController {

    @Autowired
    WsnNoiseService wsnNoiseService;
    
    /**
     * 温度数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnNoisePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取温度数据表列表
     * @param wsnNoise
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnNoiseList(WsnNoise wsnNoise) {
        List<WsnNoise> wsnNoiseList = wsnNoiseService.findWsnNoiseList(wsnNoise);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnNoiseList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnNoiseAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 温度数据表保存
     * @param wsnNoise
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnNoise(WsnNoise wsnNoise) {
        wsnNoiseService.saveWsnNoise(wsnNoise);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnNoiseUpdatePage(Model model, @PathVariable String id) {
        WsnNoise wsnNoise = wsnNoiseService.findWsnNoiseById(Integer.parseInt(id));
        model.addAttribute("wsnNoise", wsnNoise);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 温度数据表根据主键更新
     * @param wsnNoise
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnNoise(WsnNoise wsnNoise) {
        wsnNoiseService.updateWsnNoiseById(wsnNoise);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnNoiseByIds(@PathVariable String ids) {
        wsnNoiseService.deleteWsnNoiseByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询温度数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnNoiseById(Model model, @PathVariable String id) {
        WsnNoise wsnNoise = new WsnNoise();
        wsnNoise.setId(Integer.parseInt(id));
        List<WsnNoise> wsnNoiseList = wsnNoiseService.findWsnNoiseList(wsnNoise);
        if(wsnNoiseList != null && wsnNoiseList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnNoise", wsnNoiseList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
