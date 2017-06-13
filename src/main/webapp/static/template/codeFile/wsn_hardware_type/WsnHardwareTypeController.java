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

import com.ai.mnt.model.device.WsnHardwareType;
import com.ai.mnt.service.device.WsnHardwareTypeService;

/**
 * @Title: WsnHardwareTypeController 
 * @Description: WsnHardwareTypeController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

@Controller
@RequestMapping("/device")
public class WsnHardwareTypeController {

    @Autowired
    WsnHardwareTypeService wsnHardwareTypeService;
    
    /**
     * 硬件类型界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/type/page")
    public String showWsnHardwareTypePage(Model model) {
        return "device/type/device_type_query";
    }
    
    /**
     * 获取硬件类型列表
     * @param wsnHardwareType
     * @return Map<String, Object>
     */
    @RequestMapping("/type/query")
    @ResponseBody
    public Map<String, Object> getWsnHardwareTypeList(WsnHardwareType wsnHardwareType) {
        List<WsnHardwareType> wsnHardwareTypeList = wsnHardwareTypeService.findWsnHardwareTypeList(wsnHardwareType);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHardwareTypeList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 硬件类型新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/type/add_page")
    public String showWsnHardwareTypeAddPage(Model model) {
        return "device/type/device_type_add";
    }
    
    /**
     * 硬件类型保存
     * @param wsnHardwareType
     * @return Map<String, Object>
     */
    @RequestMapping("/type/add")
    @ResponseBody
    public Map<String, Object> saveWsnHardwareType(WsnHardwareType wsnHardwareType) {
        wsnHardwareTypeService.saveWsnHardwareType(wsnHardwareType);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 硬件类型更新界面跳转
     * @param  model
     * @param  typeId
     * @return
     */
    @RequestMapping("/type/update_page/{typeId}")
    public String showWsnHardwareTypeUpdatePage(Model model, @PathVariable String typeId) {
        WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(Integer.parseInt(typeId));
        model.addAttribute("wsnHardwareType", wsnHardwareType);
        return "device/type/device_type_update";
    }
    
    /**
     * 硬件类型根据主键更新
     * @param wsnHardwareType
     * @return
     */
    @RequestMapping("/type/update")
    @ResponseBody
    public Map<String, Object> updateWsnHardwareType(WsnHardwareType wsnHardwareType) {
        wsnHardwareTypeService.updateWsnHardwareTypeByTypeId(wsnHardwareType);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 硬件类型根据主键批量删除
     * @param typeIds
     * @return Map<String, Object>
     */
    @RequestMapping("/type/delete/{typeIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnHardwareTypeByTypeIds(@PathVariable String typeIds) {
        wsnHardwareTypeService.deleteWsnHardwareTypeByTypeIds(typeIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询硬件类型详细信息
     * @param model
     * @return
     */
    @RequestMapping("/type/{typeId}/page")
    public String queryWsnHardwareTypeByTypeId(Model model, @PathVariable String typeId) {
        WsnHardwareType wsnHardwareType = new WsnHardwareType();
        wsnHardwareType.setTypeId(Integer.parseInt(typeId));
        List<WsnHardwareType> wsnHardwareTypeList = wsnHardwareTypeService.findWsnHardwareTypeList(wsnHardwareType);
        if(wsnHardwareTypeList != null && wsnHardwareTypeList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnHardwareType", wsnHardwareTypeList.get(0));
        }
        return "device/type/device_type_info";
    }
}
