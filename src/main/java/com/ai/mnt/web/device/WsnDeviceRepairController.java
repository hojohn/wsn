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

import com.ai.mnt.common.cache.BaseDataCache;
import com.ai.mnt.model.device.WsnDeviceRepair;
import com.ai.mnt.service.device.WsnDeviceRepairService;

/**
 * @Title: WsnDeviceRepairController 
 * @Description: WsnDeviceRepairController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-15
 */

@Controller
@RequestMapping("/device")
public class WsnDeviceRepairController {

    @Autowired
    WsnDeviceRepairService wsnDeviceRepairService;
    
    /**
     * 维修记录界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/repair/page")
    public String showWsnDeviceRepairPage(Model model) {
        return "wsn_device/repair/device_repair_query";
    }
    
    /**
     * 获取维修记录列表
     * @param wsnDeviceRepair
     * @return Map<String, Object>
     */
    @RequestMapping("/repair/query")
    @ResponseBody
    public Map<String, Object> getWsnDeviceRepairList(WsnDeviceRepair wsnDeviceRepair) {
        List<WsnDeviceRepair> wsnDeviceRepairList = wsnDeviceRepairService.findWsnDeviceRepairList(wsnDeviceRepair);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDeviceRepairList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 维修记录新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/repair/add_page")
    public String showWsnDeviceRepairAddPage(Model model) {
        return "wsn_device/repair/device_repair_add";
    }
    
    /**
     * 维修记录保存
     * @param wsnDeviceRepair
     * @return Map<String, Object>
     */
    @RequestMapping("/repair/add")
    @ResponseBody
    public Map<String, Object> saveWsnDeviceRepair(WsnDeviceRepair wsnDeviceRepair) {
        wsnDeviceRepairService.saveWsnDeviceRepair(wsnDeviceRepair);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 维修记录更新界面跳转
     * @param  model
     * @param  repairId
     * @return
     */
    @RequestMapping("/repair/update_page/{repairId}")
    public String showWsnDeviceRepairUpdatePage(Model model, @PathVariable String repairId) {
        WsnDeviceRepair wsnDeviceRepair = wsnDeviceRepairService.findWsnDeviceRepairByRepairId(Integer.parseInt(repairId));
        model.addAttribute("wsnDeviceRepair", wsnDeviceRepair);
        return "wsn_device/repair/device_repair_update";
    }
    
    /**
     * 维修记录根据主键更新
     * @param wsnDeviceRepair
     * @return
     */
    @RequestMapping("/repair/update")
    @ResponseBody
    public Map<String, Object> updateWsnDeviceRepair(WsnDeviceRepair wsnDeviceRepair) {
        wsnDeviceRepairService.updateWsnDeviceRepairByRepairId(wsnDeviceRepair);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 维修记录根据主键批量删除
     * @param repairIds
     * @return Map<String, Object>
     */
    @RequestMapping("/repair/delete/{repairIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnDeviceRepairByRepairIds(@PathVariable String repairIds) {
        wsnDeviceRepairService.deleteWsnDeviceRepairByRepairIds(repairIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询维修记录详细信息
     * @param model
     * @return
     */
    @RequestMapping("/repair/{repairId}/page")
    public String queryWsnDeviceRepairByRepairId(Model model, @PathVariable String repairId) {
        WsnDeviceRepair wsnDeviceRepair = new WsnDeviceRepair();
        wsnDeviceRepair.setRepairId(Integer.parseInt(repairId));
        List<WsnDeviceRepair> wsnDeviceRepairList = wsnDeviceRepairService.findWsnDeviceRepairList(wsnDeviceRepair);
        if(wsnDeviceRepairList != null && wsnDeviceRepairList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDeviceRepair", wsnDeviceRepairList.get(0));
        }
        return "device/repair/device_repair_info";
    }
    
    /**
     * 维修记录--弹出
     * @param model
     * @return
     */
    @RequestMapping("/repair/{deviceRfid}/pageList")
    public String findRepairListByDeviceRfid(@PathVariable String deviceRfid, Model model) {
       WsnDeviceRepair wsnDeviceRepair = new WsnDeviceRepair();
       wsnDeviceRepair.setDeleteFlag("0");
       wsnDeviceRepair.setDeviceRfid(Integer.parseInt(deviceRfid));
       
        List<WsnDeviceRepair> wsnDeviceRepairList = wsnDeviceRepairService.findWsnDeviceRepairList(wsnDeviceRepair);
        model.addAttribute("repairList", wsnDeviceRepairList);
        
        return "wsn_device/repair/device_repair_list";
    }
    
    
}
