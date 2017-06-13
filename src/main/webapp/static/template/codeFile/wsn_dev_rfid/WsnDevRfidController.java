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

import com.ai.mnt.model.device.WsnDevRfid;
import com.ai.mnt.service.device.WsnDevRfidService;

/**
 * @Title: WsnDevRfidController 
 * @Description: WsnDevRfidController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */

@Controller
@RequestMapping("/device")
public class WsnDevRfidController {

    @Autowired
    WsnDevRfidService wsnDevRfidService;
    
    /**
     * 标签设备关联界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/page")
    public String showWsnDevRfidPage(Model model) {
        return "device/rfid/device_rfid_query";
    }
    
    /**
     * 获取标签设备关联列表
     * @param wsnDevRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/query")
    @ResponseBody
    public Map<String, Object> getWsnDevRfidList(WsnDevRfid wsnDevRfid) {
        List<WsnDevRfid> wsnDevRfidList = wsnDevRfidService.findWsnDevRfidList(wsnDevRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDevRfidList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签设备关联新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/add_page")
    public String showWsnDevRfidAddPage(Model model) {
        return "device/rfid/device_rfid_add";
    }
    
    /**
     * 标签设备关联保存
     * @param wsnDevRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/add")
    @ResponseBody
    public Map<String, Object> saveWsnDevRfid(WsnDevRfid wsnDevRfid) {
        wsnDevRfidService.saveWsnDevRfid(wsnDevRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签设备关联更新界面跳转
     * @param  model
     * @param  rfDevId
     * @return
     */
    @RequestMapping("/rfid/update_page/{rfDevId}")
    public String showWsnDevRfidUpdatePage(Model model, @PathVariable String rfDevId) {
        WsnDevRfid wsnDevRfid = wsnDevRfidService.findWsnDevRfidByRfDevId(Integer.parseInt(rfDevId));
        model.addAttribute("wsnDevRfid", wsnDevRfid);
        return "device/rfid/device_rfid_update";
    }
    
    /**
     * 标签设备关联根据主键更新
     * @param wsnDevRfid
     * @return
     */
    @RequestMapping("/rfid/update")
    @ResponseBody
    public Map<String, Object> updateWsnDevRfid(WsnDevRfid wsnDevRfid) {
        wsnDevRfidService.updateWsnDevRfidByRfDevId(wsnDevRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签设备关联根据主键批量删除
     * @param rfDevIds
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/delete/{rfDevIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnDevRfidByRfDevIds(@PathVariable String rfDevIds) {
        wsnDevRfidService.deleteWsnDevRfidByRfDevIds(rfDevIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询标签设备关联详细信息
     * @param model
     * @return
     */
    @RequestMapping("/rfid/{rfDevId}/page")
    public String queryWsnDevRfidByRfDevId(Model model, @PathVariable String rfDevId) {
        WsnDevRfid wsnDevRfid = new WsnDevRfid();
        wsnDevRfid.setRfDevId(Integer.parseInt(rfDevId));
        List<WsnDevRfid> wsnDevRfidList = wsnDevRfidService.findWsnDevRfidList(wsnDevRfid);
        if(wsnDevRfidList != null && wsnDevRfidList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDevRfid", wsnDevRfidList.get(0));
        }
        return "device/rfid/device_rfid_info";
    }
}
