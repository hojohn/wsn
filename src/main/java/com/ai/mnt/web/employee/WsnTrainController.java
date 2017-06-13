package com.ai.mnt.web.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.employee.WsnTrain;
import com.ai.mnt.service.employee.WsnTrainService;

/**
 * @Title: WsnTrainController 
 * @Description: WsnTrainController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */

@Controller
@RequestMapping("/employee")
public class WsnTrainController {

    @Autowired
    WsnTrainService wsnTrainService;
    
    /**
     * 培训教育界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/train/page")
    public String showWsnTrainPage(Model model) {
        return "wsn_employee/train/employee_train_query";
    }
    
    /**
     * 获取培训教育列表
     * @param wsnTrain
     * @return Map<String, Object>
     */
    @RequestMapping("/train/query")
    @ResponseBody
    public Map<String, Object> getWsnTrainList(WsnTrain wsnTrain) {
        List<WsnTrain> wsnTrainList = wsnTrainService.findWsnTrainList(wsnTrain);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnTrainList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 培训教育新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/train/add_page")
    public String showWsnTrainAddPage(Model model) {
        return "wsn_employee/train/employee_train_add";
    }
    
    /**
     * 培训教育保存
     * @param wsnTrain
     * @return Map<String, Object>
     */
    @RequestMapping("/train/add")
    @ResponseBody
    public Map<String, Object> saveWsnTrain(WsnTrain wsnTrain) {
        wsnTrainService.saveWsnTrain(wsnTrain);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 培训教育更新界面跳转
     * @param  model
     * @param  trainId
     * @return
     */
    @RequestMapping("/train/update_page/{trainId}")
    public String showWsnTrainUpdatePage(Model model, @PathVariable String trainId) {
        WsnTrain wsnTrain = wsnTrainService.findWsnTrainByTrainId(Integer.parseInt(trainId));
        model.addAttribute("wsnTrain", wsnTrain);
        return "wsn_employee/train/employee_train_update";
    }
    
    /**
     * 培训教育根据主键更新
     * @param wsnTrain
     * @return
     */
    @RequestMapping("/train/update")
    @ResponseBody
    public Map<String, Object> updateWsnTrain(WsnTrain wsnTrain) {
        wsnTrainService.updateWsnTrainByTrainId(wsnTrain);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 培训教育根据主键批量删除
     * @param trainIds
     * @return Map<String, Object>
     */
    @RequestMapping("/train/delete/{trainIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnTrainByTrainIds(@PathVariable String trainIds) {
        wsnTrainService.deleteWsnTrainByTrainIds(trainIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询培训教育详细信息
     * @param model
     * @return
     */
    @RequestMapping("/train/{trainId}/page")
    public String queryWsnTrainByTrainId(Model model, @PathVariable String trainId) {
        WsnTrain wsnTrain = new WsnTrain();
        wsnTrain.setTrainId(Integer.parseInt(trainId));
        List<WsnTrain> wsnTrainList = wsnTrainService.findWsnTrainList(wsnTrain);
        if(wsnTrainList != null && wsnTrainList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnTrain", wsnTrainList.get(0));
        }
        return "wsn_employee/train/employee_train_info";
    }
}
