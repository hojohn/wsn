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

import com.ai.mnt.model.sensor.WsnDrift;
import com.ai.mnt.service.sensor.WsnDriftService;

/**
 * @Title: WsnDriftController 
 * @Description: WsnDriftController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnDriftController {

    @Autowired
    WsnDriftService wsnDriftService;
    
    /**
     * 位移数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnDriftPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取位移数据表列表
     * @param wsnDrift
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnDriftList(WsnDrift wsnDrift) {
        List<WsnDrift> wsnDriftList = wsnDriftService.findWsnDriftList(wsnDrift);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDriftList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 位移数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnDriftAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 位移数据表保存
     * @param wsnDrift
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnDrift(WsnDrift wsnDrift) {
        wsnDriftService.saveWsnDrift(wsnDrift);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 位移数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnDriftUpdatePage(Model model, @PathVariable String id) {
        WsnDrift wsnDrift = wsnDriftService.findWsnDriftById(Integer.parseInt(id));
        model.addAttribute("wsnDrift", wsnDrift);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 位移数据表根据主键更新
     * @param wsnDrift
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnDrift(WsnDrift wsnDrift) {
        wsnDriftService.updateWsnDriftById(wsnDrift);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 位移数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnDriftByIds(@PathVariable String ids) {
        wsnDriftService.deleteWsnDriftByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询位移数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnDriftById(Model model, @PathVariable String id) {
        WsnDrift wsnDrift = new WsnDrift();
        wsnDrift.setId(Integer.parseInt(id));
        List<WsnDrift> wsnDriftList = wsnDriftService.findWsnDriftList(wsnDrift);
        if(wsnDriftList != null && wsnDriftList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDrift", wsnDriftList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
