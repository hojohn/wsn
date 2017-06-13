package com.ai.mnt.web.bracelet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.bracelet.WsnBraceletInfo;
import com.ai.mnt.model.device.WsnHardwareType;
import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.service.bracelet.WsnBraceletInfoService;
import com.ai.mnt.service.device.WsnHardwareTypeService;
import com.ai.mnt.service.device.WsnMonitorObjService;

/**
 * @Title: WsnBraceletInfoController 
 * @Description: WsnBraceletInfoController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-7
 */

@Controller
@RequestMapping("/bracelet")
public class WsnBraceletInfoController {

    @Autowired
    WsnBraceletInfoService wsnBraceletInfoService;
    
    @Autowired
    WsnHardwareTypeService wsnHardwareTypeService;
    
    @Autowired
    WsnMonitorObjService wsnMonitorObjService;
    
    /**
     * 人员视频监控
     */
    
    /**
     * 
     * ok
     * 可穿戴设备信息表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnBraceletInfoPage(Model model,@RequestParam("id") String id,@RequestParam("hid") String hid) {
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("typeList", list);
        List<WsnBraceletInfo>wBraceletInfos =  wsnBraceletInfoService.findWsnBraceletInfoByBware(id);
        if (null == wBraceletInfos || wBraceletInfos.size()==0) {
            return "bracelet/info/bracelet_info_add";
        }else {
            String [] sensor = new String[4];
            String [] sample = new String[4];
            String [] alrm = new String[4];
            String [] metric = new String[4];
            for (int i = 0;i<wBraceletInfos.size();i++) {
                sensor[i] = wBraceletInfos.get(i).getSensorName();
                sample[i] = wBraceletInfos.get(i).getSampleData();
                alrm[i] = wBraceletInfos.get(i).getAlrmData();
                metric[i] = wBraceletInfos.get(i).getMetricData();
            }
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wBraceletInfos.get(0).getTypeId());
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            
            model.addAttribute("sensor", sensor);
            model.addAttribute("sample", sample);
            model.addAttribute("alrm", alrm);
            model.addAttribute("metric", metric);
            model.addAttribute("wsnBraceletInfo", wBraceletInfos.get(0));
            model.addAttribute("hid", hid);
            
            return "bracelet/info/bracelet_info_info";
        }
       
    }
    
  
    /**
     * ok
     * 可穿戴设备信息表保存
     * @param wsnBraceletInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        String [] sensorName=wsnBraceletInfo.getSensorName().split(",");
        String [] sampleData=wsnBraceletInfo.getSampleData().split(",");
        String [] alrmData=wsnBraceletInfo.getAlrmData().split(",");
        String [] metricData=wsnBraceletInfo.getMetricData().split(",");
        for (int i = 0; i < 4; i++) {
            wsnBraceletInfo.setSensorName(sensorName[i]);
            wsnBraceletInfo.setSampleData(sampleData[i]);
            wsnBraceletInfo.setAlrmData(alrmData[i]);
            wsnBraceletInfo.setMetricData(metricData[i]);
            wsnBraceletInfoService.saveWsnBraceletInfo(wsnBraceletInfo);
        }
        
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * ok
     * 可穿戴设备信息表更新界面跳转
     * @param  model
     * @param  bwareId
     * @return
     */
    @RequestMapping("/info/update_page/{bwareId}")
    public String showWsnBraceletInfoUpdatePage(Model model, @PathVariable String bwareId) {
        List<WsnBraceletInfo>wBraceletInfos =  wsnBraceletInfoService.findWsnBraceletInfoByBware(bwareId);
        String [] sensor = new String[4];
        String [] sample = new String[4];
        String [] alrm = new String[4];
        String [] metric = new String[4];
        for (int i = 0;i<wBraceletInfos.size();i++) {
            sensor[i] = wBraceletInfos.get(i).getSensorName();
            sample[i] = wBraceletInfos.get(i).getSampleData();
            alrm[i] = wBraceletInfos.get(i).getAlrmData();
            metric[i] = wBraceletInfos.get(i).getMetricData();
        }
        WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wBraceletInfos.get(0).getTypeId());
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("typeList", list);
        model.addAttribute("wsnHardwareType", wsnHardwareType);
        model.addAttribute("sensor", sensor);
        model.addAttribute("sample", sample);
        model.addAttribute("alrm", alrm);
        model.addAttribute("metric", metric);
        model.addAttribute("wsnBraceletInfo", wBraceletInfos.get(0));
        return "bracelet/info/bracelet_info_update";
    }
    
    /**
     * 可穿戴设备信息表根据主键更新
     * @param wsnBraceletInfo
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        String [] sensorName=wsnBraceletInfo.getSensorName().split(",");
        String [] sampleData=wsnBraceletInfo.getSampleData().split(",");
        String [] alrmData=wsnBraceletInfo.getAlrmData().split(",");
        String [] metricData=wsnBraceletInfo.getMetricData().split(",");
        for (int i = 0; i < 4; i++) {
            wsnBraceletInfo.setSensorName(sensorName[i]);
            wsnBraceletInfo.setSampleData(sampleData[i]);
            wsnBraceletInfo.setAlrmData(alrmData[i]);
            wsnBraceletInfo.setMetricData(metricData[i]);
            wsnBraceletInfoService.updateWsnBraceletInfoByBwareId(wsnBraceletInfo);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    
    
    
}
