package com.ai.mnt.web.device;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.device.WsnDevice;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.device.WsnHardwareType;
import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.service.device.WsnDeviceService;
import com.ai.mnt.service.device.WsnHardwareInfoService;
import com.ai.mnt.service.device.WsnHardwareTypeService;
import com.ai.mnt.service.device.WsnMonitorObjService;
import com.ai.mnt.service.device.WsnSensorService;

/**
 * @Title: WsnDeviceController 
 * @Description: WsnDeviceController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-4
 */

@Controller
@RequestMapping("/device")
public class WsnDeviceController {

    @Autowired
    WsnDeviceService wsnDeviceService;
    
    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
    
    @Autowired
    WsnSensorService wsnSensorService;
   
    @Autowired
    WsnMonitorObjService wsnMonitorObjService;
    
    @Autowired
     WsnHardwareTypeService wsnHardwareTypeService;
    /**
     * 设备信息界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnDevicePage(Model model) {
        return "wsn_device/device_info_query";
    }
    
    
    /**
     * 服务控制
     * @author hezq
     * 
     */
    @RequestMapping("/service/control")
    public String showServiceControl(Model model){
        
        return "" ;
    }
    
    
    /**
     * 到导出的数据
     * @author hezq
     * @throws ParseException 
     */
    @RequestMapping("/export/excel")
    @ResponseBody
    public Map<String, Object> exportData(WsnSensor wsnSensor,HttpServletResponse response)throws FileNotFoundException, IOException, ParseException{
        List<WsnTemperature> wList= wsnSensorService.findWsnSensorDataList(wsnSensor);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("传感器数据");  
       // HSSFRow row0=sheet.createRow(0); 
       // HSSFCell cell=row0.createCell(0);
        //cell.setCellValue("传感器历史数据"); 
        //sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        List<HSSFRow> list = new ArrayList<HSSFRow>();
        HSSFRow row1=sheet.createRow(1);
        row1.createCell(0).setCellValue("传感器编号");  
        row1.createCell(1).setCellValue("值");      
        row1.createCell(2).setCellValue("时间");
        row1.createCell(3).setCellValue("频率");
        row1.createCell(4).setCellValue("状态");
        
        for(int i=0;i<wList.size();i++){
            //list.set(i, sheet.createRow(i+2));
            list.add(sheet.createRow(i+2));
        }
        for(int i=0;i<list.size();i++){
            String creTimeString =  new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(wList.get(i).getCreateTime());
            list.get(i).createCell(0).setCellValue(wList.get(i).getWareId());  
            list.get(i).createCell(1).setCellValue(wList.get(i).getTemperatureValue());
            list.get(i).createCell(2).setCellValue(creTimeString);
            list.get(i).createCell(3).setCellValue(wList.get(i).getRate());
            list.get(i).createCell(4).setCellValue(wList.get(i).getState());
            
        }
        OutputStream output=response.getOutputStream();
        response.reset();  
        response.setHeader("Content-disposition", "attachment; filename=details_"+String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", System.currentTimeMillis()) + ".xls");  
        response.setContentType("application/vnd.ms-excel;charset=gb2312 ");
        wb.write(output);
        output.close();
        return null;
    }
    /**
     * ok
     * 获取要到导出的数据
     * @author hezq
     */
    @RequestMapping("/export/query")
    @ResponseBody
    public Map<String, Object> getExportData(WsnSensor wsnSensor){
        Map<String, Object> map = new HashMap<>();
        try{
            List<WsnTemperature> wwList= wsnSensorService.findWsnSensorDataList(wsnSensor);
            map.put("data", wwList);
        }catch(Exception e){
            map.put("data", "");
        }
        return map;
    }
    
    
    public Map<String, Object> getExportData1(WsnSensor wsnSensor){
        List<WsnSensor>sList = new ArrayList<WsnSensor>();
        List<WsnTemperature> wList= wsnSensorService.findWsnSensorDataList(wsnSensor);
       
        Map<String, Object> map = new HashMap<>();
        map.put("data", wList);
        return map;
    }
    
    /**
     * 数据备份页面跳转
     * @author hezq
     * 
     */
    @RequestMapping("/data/copy")
    public String showDataCopy(Model model){
        List<WsnMonitorObj>wsnMonitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("moniList", wsnMonitorObjs);
        return "sensor_data/sensor_data_copy" ;
    }
    
    /**
     * ok
     * 历史数据*****************************************************
     * @param  model
     * @return String
     */
    @RequestMapping("/history/data/page")
    public String showHistoryPage(Model model) {
        List<WsnMonitorObj>wsnMonitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
      
        model.addAttribute("moniList", wsnMonitorObjs);
        return "sensor_data/sensor_his_table";
    }
    
    //根据监控对象获得传感器 下拉框
    @RequestMapping("/index/sensor_data")
    @ResponseBody
    public Map<String, Object> getSensorData(String opt){
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findWsnHardByObj(opt);
        Double dString = Math.random()*10;
        Map<String, Object> map = new HashMap<>();
        map.put("d", dString);
        map.put("data", wsnHardwareInfos);
        return map;
    }
    
    /**
     * 首页数据显示
     * 
     */
    @RequestMapping("/history/sensor_list")
    @ResponseBody
    public Map<String, Object> getSensorByObj(String opt){
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findWsnHardByObj(opt);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHardwareInfos);
        return map;
    }
    
    /**
     * 测试*********************************测试********************
     * @param  model
     * @return String
     */
    @RequestMapping("/chart/page")
    public String showWsn(Model model) {
       /* int temperature =101;
        wsnSensor.setTemperatureId(temperature);
        List<WsnSensor> wsnSensorList = wsnSensorService.findWsnSensorList(wsnSensor);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnSensorList);*/
        
        return "wsn_device/highcharts";
    }
    
    /**
     * 声称二维码界面跳转========================================
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/qrcode/{deviceId}/page")
    public String showWsnDeviceQrcodePage(Model model, @PathVariable String deviceId) {
        model.addAttribute("id", deviceId);
        return "wsn_device/hardware/device_qrcode_page";
    }
    
    
    
    /**
     * 获取传感器历史数据
     * @param wsnDevice
     * @return Map<String, Object>
     * @throws ParseException 
     */
    @RequestMapping("/sensor/history")
    @ResponseBody
    public Map<String, Object> getHistoryDataList(Model model,String strSensor,WsnSensor wsnSensor,String strBeginDate,String strEndDate) throws ParseException {
        wsnSensor.setBeginDate(strBeginDate);
        wsnSensor.setEndDate(strEndDate);
        Date beginDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm" ).parse(strBeginDate);
        Date endDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm" ).parse(strEndDate);
        System.out.println(endDate);
        //得到时间差的毫秒级
        Long endSubtractionbeginLong = endDate.getTime() - beginDate.getTime();
        //将时间差分成24分
        long interval = endSubtractionbeginLong/24L;
        Float [] yFloats = new Float[24];
        String [] xStrings = new String[24];
        for (int i = 1; i <= 24; i++) {
            Long newBegin = beginDate.getTime()+(interval * i);
            Long newEnd = beginDate.getTime() + (interval *(i+1) );
            String bDate= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newBegin);
            String eDate= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newEnd);
            wsnSensor.setBeginDate(bDate);
            wsnSensor.setEndDate(eDate);
            yFloats[i-1]  = wsnSensorService.findDataAvg(wsnSensor);
            xStrings[i-1] = bDate;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("xName", xStrings);
        map.put("yData", yFloats);
        map.put("status", "1");
        return map;
    }
    @RequestMapping("/sensor/history1")
    @ResponseBody
    public Map<String, Object> getHistoryDataList1
            (Model model,WsnSensor wsnSensor,String strSensor,String strBeginDate,String strEndDate) throws ParseException {
        //拿到时间
        Date beginDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm" ).parse(strBeginDate);
        Date endDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm" ).parse(strEndDate);
      //得到时间差的毫秒级
        Long endSubtractionbeginLong = endDate.getTime() - beginDate.getTime();
        //将时间差分成24分
        long interval = endSubtractionbeginLong/24L;
        Float [] yFloats = new Float[24];
        String [] xStrings = new String[24];
        for (int i = 1; i <= 24; i++) {
            Long newBegin = beginDate.getTime()+(interval * i);
            Long newEnd = beginDate.getTime() + (interval *(i+1) );
            String bDate= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newBegin);
            String eDate= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newEnd);
            //Date bbDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newEnd);
            wsnSensor.setBeginDate(bDate);
            wsnSensor.setEndDate(eDate);
            wsnSensor.setSensor(strSensor);
            //wsnSensorService.findWsnSensorDataList(wsnSensor);
            yFloats[i-1]  = wsnSensorService.findDataAvg(wsnSensor);
            xStrings[i-1] = bDate;
        }
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(strSensor);
        String metric = wsnHardwareInfo.getInfoThree();
        for (int i = 0; i < yFloats.length; i++) {
            if (yFloats[i] ==null || yFloats[i].equals("")) {
                if (i == 0) {
                    for(int j = 1;j <yFloats.length;j++){
                        if (yFloats[j]!=null) {
                            yFloats[0] = yFloats[j];
                            break;
                        }
                    }
                }else if (i == yFloats.length-1) {
                    yFloats[i] = yFloats[i-1];
                }else {
                   for( int t = i+1;t<yFloats.length;t++){
                       if (yFloats[t]!=null) {
                        yFloats[i] = (yFloats[t]+yFloats[i-1])/2;
                        break;
                    }
                   }
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("metric", metric);
        map.put("xName", xStrings);
        map.put("yData", yFloats);
        map.put("status", "1");
        return map;
    }
    
    
    /**
     * 首页传感器实时数据
     * @param id
     * @return String
     * 
     */
    @RequestMapping("/sensor")
    public String getWsnSensorData(Model model,@RequestParam("id") String id) {
        WsnHardwareInfo wsnHardwareInfo=wsnHardwareInfoService.findWsnHardwareInfoByWareId(id);
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
        return "sensor_data/sensor_data_index";
    }
    
    /**
     * 获取传感器数据
     * 
     * @param wsnSensor
     * @return Map<String, Object>
     * @throws ParseException 
     */
    @RequestMapping("/sensor/query")
    @ResponseBody
    public Map<String, Object> getWsnSensorList(String wareId,Model model,WsnSensor wsnSensor) throws ParseException {
       // 用一个表专门来存放多有传感器的最新数据
       // String newData = wsnSensorService.findDate(wareId);
       // List<WsnTempData>wwwwlDatas = wsnSensorService.findAllllll();
        WsnTempData wsnTempData = wsnSensorService.findWsnSensorByWareId(wareId);
        //int id = new Random().nextInt(80) +1;
       // wsnSensor.setId(id);
        //WsnSensor wsnSensor2 = wsnSensorService.findWsnSensorById(id);
        Float tFloat = Float.parseFloat(wsnTempData.getTemperatureValue());
        Date hFloat = wsnTempData.getCreateTime();
        Map<String, Object> map = new HashMap<>();
        map.put("h", hFloat);
        map.put("t", tFloat);
        return map;
    }
    
    
    
    //////////
    public String getSensorD(String wareId){
        String ss = wareId.substring(4, 6);
        if (ss.equals("WD")) {
            String newData = wsnSensorService.findDate(wareId);
        }else if (ss.equals("SD")) {
            
        }else if (ss.equals("YL")) {
            
        }else if (ss.equals("CO")) {
            
        }else if (ss.equals("EY")) {
            
        }else if (ss.equals("YQ")) {
            
        }else if (ss.equals("JW")) {
            
        }else if (ss.equals("YW")) {
            
        }else if (ss.equals("FC")) {
            
        }else if (ss.equals("WY")) {
            
        }else {
            return "";
        }
        
        return null;
    }
    
    
    /**
     * 获取设备信息列表
     * @param wsnDevice
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnDeviceList(WsnDevice wsnDevice) {
        wsnDevice.setDeleteFlag("0");
        List<WsnDevice> wsnDeviceList = wsnDeviceService.findWsnDeviceList(wsnDevice);
        System.out.println(wsnDeviceList.isEmpty()+"==============");
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDeviceList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnDeviceAddPage(Model model) {
        return "wsn_device/device_info_add";
    }
    
    /**
     * 设备信息保存
     * @param wsnDevice
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnDevice(WsnDevice wsnDevice) {
        wsnDeviceService.saveWsnDevice(wsnDevice);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息更新界面跳转
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/{deviceId}")
    public String showWsnDeviceUpdatePage(Model model, @PathVariable String deviceId) {
        WsnDevice wsnDevice = wsnDeviceService.findWsnDeviceByDeviceId(Integer.parseInt(deviceId));
        model.addAttribute("wsnDevice", wsnDevice);
        return "wsn_device/device_info_update";
    }
    
    
    /**
     * 服务器节点从info跳转到update修改
     * @param  model
     * @return String
     */
    @RequestMapping("/server/update_page")
    public String showWsnServerUpdate(Model model, WsnHardwareInfo wsnHardwareInfo) {
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.findWsnHardwareInfoByWare(wsnHardwareInfo.getWareId());
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(4);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("temList", wsnHardwareInfos);
        
        List<WsnHardwareInfo> deviceList = wsnHardwareInfoService.findAllWsnHardwareInfo();
        model.addAttribute("deviceList", deviceList);
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo2);
        return "wsn_device/server/server_update";
    }
    /**
     * ok
     * 服务器  =======================  服务器===================
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/server_page")
    public String showWsnDeviceServerPage(Model model,@RequestParam("id") String id,@RequestParam("hid") String hid) {
        
        String wareId = id;
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(wareId);
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(4);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("temList", wsnHardwareInfos);
        
        if (wsnHardwareInfo ==null) {
            return "wsn_device/server/server_add";
        }else {
            
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wsnHardwareInfo.getTypeId());
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            model.addAttribute("hid", hid);
            return "wsn_device/server/server_info";
        }
  
    
    }
    
    /**
     * ok
     * 终端节点从info跳转到update修改
     * @param  model
     * @return String
     */
    @RequestMapping("/terminal/update_page")
    public String showWsnTerminalUpdate(Model model, WsnHardwareInfo wsnHardwareInfo) {
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.findWsnHardwareInfoByWare(wsnHardwareInfo.getWareId());
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(3);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("moveList", wsnHardwareInfos);
        
       /* List<WsnHardwareInfo> temList = wsnHardwareInfoService.findWsnHardwareInfoListByInfo2(wsnHardwareInfo.getInfoThree());
        List<WsnHardwareInfo> deviceList = wsnHardwareInfoService.findAllWsnHardwareInfo();*/
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo2);
        return "wsn_device/terminal/terminal_update";
    }
    
    
    /**
     * ok
     * 终端  ===================  终端节点===================
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/terminal_page")
    public String showWsnDeviceTerminalPage(Model model,@RequestParam("id") String id,@RequestParam("hid") String hid) {
        
        String wareId = id;
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(wareId);
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(3);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("moveList", wsnHardwareInfos);
        
        if (wsnHardwareInfo==null ) {
            return "wsn_device/terminal/terminal_add";
        }else {
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wsnHardwareInfo.getTypeId());
            //查找终端拥有的传感器
            ArrayList<String> senList = new ArrayList<String>(); 
            String [] move= wsnHardwareInfo.getInfoOne().split(",");
            for (int i = 0; i < move.length; i++) {
                List<WsnHardwareInfo>wsnHardwareInfoss = wsnHardwareInfoService.findWsnHardwareInfoListByInfo3(move[i]);
                if (wsnHardwareInfoss.size()>0) {
                    WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoss.get(0);
                    if (wsnHardwareInfo2.getInfoOne()==null) {
                        senList.add("");
                    }else {
                        String[]senStrings = wsnHardwareInfo2.getInfoOne().split(",");
                        for (int j = 0; j < senStrings.length; j++) {
                            senList.add(senStrings[j]);
                            System.out.println(senStrings[j]);
                        }
                    }
                        
                }else {
                    senList.add("");
                }
            }
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            model.addAttribute("senList", senList);
            model.addAttribute("hid", hid);
            return "wsn_device/terminal/terminal_info";
        }
  
    
    }
    
    /**
     * 移动节点修改
     * ok
     * @param  model
     * @return String
     */
    @RequestMapping("/move_node/update_page")
    public String showWsnMonitorMoveUpdate(Model model, WsnHardwareInfo wsnHardwareInfo) {
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.findWsnHardwareInfoByWare(wsnHardwareInfo.getWareId());
        
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(1);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("senList", wsnHardwareInfos);
        
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo2);
        return "wsn_device/move/move_node_update";
    }
    
    
    /**
     * 
     * 移动  =======================  移动节点===================
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/move_node")
    public String showWsnDeviceMoveNode(Model model,@RequestParam("id") String id,@RequestParam("hid") String hid) {
        String wareId = id;
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(wareId);
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(1);
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("senList", wsnHardwareInfos);
        if (wsnHardwareInfo == null) {
            return "wsn_device/move/move_node_add";
        }else {
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wsnHardwareInfo.getTypeId());
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            model.addAttribute("hid", hid);
            return "wsn_device/move/move_node_info";
        }
    }
    
    
    /**
     * 传感器信息展示  =======================  传感器===================
     * 
     * ok
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/temperature01")
    public String showWsnDeviceUpdatePage01(Model model,@RequestParam("id") String id) {
        
        String wareId = id;
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(wareId);
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        if (wsnHardwareInfo==null) {
            return "wsn_device/hardware/device_hardware_add";
        }else {
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wsnHardwareInfo.getTypeId());
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            return "wsn_device/hardware/device_hardware_info";
        }
        
    }
    
    /**
     * 可穿戴设备信息展示  =======================  可穿戴设备===================
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/wearable")
    public String showWearableUpdatePage(Model model,@RequestParam("id") String id) {
        
        String wareId = id;
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWare(wareId);
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        
        
        if (wsnHardwareInfo==null) {
            return "wsn_device/wearable/wearable_device_add";
        }else {
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
            WsnHardwareType wsnHardwareType = wsnHardwareTypeService.findWsnHardwareTypeByTypeId(wsnHardwareInfo.getTypeId());
            model.addAttribute("wsnHardwareType", wsnHardwareType);
            return "wsn_device/wearable/wearable_device_info";
        }
        
    }
    
    /**
     * 传感器修改
     * 
     * ok
     * @param  model
     * @return String
     */
    @RequestMapping("/sensor/update_page")
    public String showWsnMonitorSensorUpdate(Model model, WsnHardwareInfo wsnHardwareInfo) {
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.findWsnHardwareInfoByWareId(wsnHardwareInfo.getWareId());
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        List<WsnMonitorObj> monitorObjs = wsnMonitorObjService.findAllWsnMonitorObj();
        model.addAttribute("typeList", list);
        model.addAttribute("objList", monitorObjs);
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo2);
        return "wsn_device/hardware/device_hardware_update";
    }
    
    /**
     * 可穿戴设备修改
     * @param  model
     * @return String
     */
    @RequestMapping("/wearable/update_page")
    public String showWearableDeviceUpdate(Model model, WsnHardwareInfo wsnHardwareInfo) {
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.findWsnHardwareInfoByWareId(wsnHardwareInfo.getWareId());
        List<WsnHardwareType> list = wsnHardwareTypeService.findAllWsnHardwareType();
        model.addAttribute("typeList", list);
        
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo2);
        return "wsn_device/wearable/wearable_device_update";
    }
    
   
    
    /**
     * 设备信息根据主键更新
     * @param wsnDevice
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnDevice(WsnDevice wsnDevice) {
        wsnDeviceService.updateWsnDeviceByDeviceId(wsnDevice);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息根据主键批量删除
     * @param deviceIds
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{deviceIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnDeviceByDeviceIds(@PathVariable String deviceIds) {
        wsnDeviceService.deleteWsnDeviceByDeviceIds(deviceIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询设备信息详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{deviceId}/page")
    public String queryWsnDeviceByDeviceId(Model model, @PathVariable String deviceId) {
        WsnDevice wsnDevice = new WsnDevice();
        wsnDevice.setDeviceId(Integer.parseInt(deviceId));
        List<WsnDevice> wsnDeviceList = wsnDeviceService.findWsnDeviceList(wsnDevice);
        if(wsnDeviceList != null && wsnDeviceList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDevice", wsnDeviceList.get(0));
        }
        return "wsn_device/device_info_info";
    }
    
    /**
     * 发卡界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/dev_bind/page")
    public String showWsnDeviceBindPage(Model model) {
        return "wsn_device/device_bind_query";
    } 
    
    /**
     * 设备绑定界面跳转
     * @param  model
     * @param  deviceId
     * @return
     */
    /*@RequestMapping("/bind/{deviceId}/page")
    public String showWsnDeviceBindPage(Model model, @PathVariable String deviceId) {
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWareId(Integer.parseInt(deviceId));
        //WsnDevice wsnDevice = wsnDeviceService.findWsnDeviceByDeviceId(Integer.parseInt(deviceId));
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
        return "wsn_device/device_bind_page";
    }*/
    /**
     * 设备绑定RFID
     * @param wsnDevice
     * @return
     */
    @RequestMapping("/bind/update")
    @ResponseBody
    public Map<String, Object> updateWsnDeviceBind(WsnDevice wsnDevice,String deviceRfid) {
        wsnDeviceService.saveWsnDevicebind(wsnDevice,deviceRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    
}
