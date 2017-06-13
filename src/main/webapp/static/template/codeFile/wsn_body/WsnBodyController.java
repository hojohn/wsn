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

import com.ai.mnt.model.sensor.WsnBody;
import com.ai.mnt.service.sensor.WsnBodyService;

/**
 * @Title: WsnBodyController 
 * @Description: WsnBodyController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

@Controller
@RequestMapping("/sensor")
public class WsnBodyController {

    @Autowired
    WsnBodyService wsnBodyService;
    
    /**
     * 温度数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnBodyPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取温度数据表列表
     * @param wsnBody
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnBodyList(WsnBody wsnBody) {
        List<WsnBody> wsnBodyList = wsnBodyService.findWsnBodyList(wsnBody);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnBodyList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnBodyAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 温度数据表保存
     * @param wsnBody
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnBody(WsnBody wsnBody) {
        wsnBodyService.saveWsnBody(wsnBody);
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
    public String showWsnBodyUpdatePage(Model model, @PathVariable String id) {
        WsnBody wsnBody = wsnBodyService.findWsnBodyById(Integer.parseInt(id));
        model.addAttribute("wsnBody", wsnBody);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 温度数据表根据主键更新
     * @param wsnBody
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnBody(WsnBody wsnBody) {
        wsnBodyService.updateWsnBodyById(wsnBody);
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
    public Map<String, Object> deleteWsnBodyByIds(@PathVariable String ids) {
        wsnBodyService.deleteWsnBodyByIds(ids);
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
    public String queryWsnBodyById(Model model, @PathVariable String id) {
        WsnBody wsnBody = new WsnBody();
        wsnBody.setId(Integer.parseInt(id));
        List<WsnBody> wsnBodyList = wsnBodyService.findWsnBodyList(wsnBody);
        if(wsnBodyList != null && wsnBodyList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnBody", wsnBodyList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
