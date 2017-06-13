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

import com.ai.mnt.model.device.WsnRfid;
import com.ai.mnt.service.device.WsnRfidService;

/**
 * @Title: WsnRfidController 
 * @Description: WsnRfidController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-18
 */

@Controller
@RequestMapping("/device")
public class WsnRfidController {

    @Autowired
    WsnRfidService wsnRfidService;
    
    /**
     * RFID管理界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/page")
    public String showWsnRfidPage(Model model) {
        return "device/rfid/device_rfid_query";
    }
    
    /**
     * 获取RFID管理列表
     * @param wsnRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/query")
    @ResponseBody
    public Map<String, Object> getWsnRfidList(WsnRfid wsnRfid) {
        List<WsnRfid> wsnRfidList = wsnRfidService.findWsnRfidList(wsnRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnRfidList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * RFID管理新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/add_page")
    public String showWsnRfidAddPage(Model model) {
        return "device/rfid/device_rfid_add";
    }
    
    /**
     * RFID管理保存
     * @param wsnRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/add")
    @ResponseBody
    public Map<String, Object> saveWsnRfid(WsnRfid wsnRfid) {
        wsnRfidService.saveWsnRfid(wsnRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * RFID管理更新界面跳转
     * @param  model
     * @param  rfidId
     * @return
     */
    @RequestMapping("/rfid/update_page/{rfidId}")
    public String showWsnRfidUpdatePage(Model model, @PathVariable String rfidId) {
        WsnRfid wsnRfid = wsnRfidService.findWsnRfidByRfidId(Integer.parseInt(rfidId));
        model.addAttribute("wsnRfid", wsnRfid);
        return "device/rfid/device_rfid_update";
    }
    
    /**
     * RFID管理根据主键更新
     * @param wsnRfid
     * @return
     */
    @RequestMapping("/rfid/update")
    @ResponseBody
    public Map<String, Object> updateWsnRfid(WsnRfid wsnRfid) {
        wsnRfidService.updateWsnRfidByRfidId(wsnRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * RFID管理根据主键批量删除
     * @param rfidIds
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/delete/{rfidIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnRfidByRfidIds(@PathVariable String rfidIds) {
        wsnRfidService.deleteWsnRfidByRfidIds(rfidIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询RFID管理详细信息
     * @param model
     * @return
     */
    @RequestMapping("/rfid/{rfidId}/page")
    public String queryWsnRfidByRfidId(Model model, @PathVariable String rfidId) {
        WsnRfid wsnRfid = new WsnRfid();
        wsnRfid.setRfidId(Integer.parseInt(rfidId));
        List<WsnRfid> wsnRfidList = wsnRfidService.findWsnRfidList(wsnRfid);
        if(wsnRfidList != null && wsnRfidList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnRfid", wsnRfidList.get(0));
        }
        return "device/rfid/device_rfid_info";
    }
}
