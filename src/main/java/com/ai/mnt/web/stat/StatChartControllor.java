package com.ai.mnt.web.stat;

import java.text.DecimalFormat; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ai.mnt.common.util.ExcelUtil;
import com.ai.mnt.model.collect.WsnCollectSts;
import com.ai.mnt.model.collect.WsnTray;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.service.bracelet.WsnBraceletInfoService;
import com.ai.mnt.service.device.WsnGetewayService;
import com.ai.mnt.service.device.WsnHardwareInfoService;
import com.ai.mnt.service.device.WsnMonitorObjService;
import com.ai.mnt.service.device.WsnSensorService;
import com.ai.mnt.web.collect.Collection;
import com.alibaba.druid.sql.ast.statement.SQLIfStatement.ElseIf;
import com.b510.tray.NowTime;

@RequestMapping("/stat")
@Controller
public class StatChartControllor {
    
    
  /*  @Autowired
    MntReleaseRecDtlService mntReleaseRecDtlService;
    
    @Autowired
    MntReleaseRecService mntReleaseRecService;
    
    @Autowired
    MntInstallOnlineInfoService mntInstallOnlineInfoService;*/
    
    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
    
    @Autowired
    WsnGetewayService wsnGetewayService;
    
    @Autowired
    WsnMonitorObjService wsnMonitorObjService;
    
    @Autowired
    WsnSensorService wsnSensorService;
    
    @Autowired
    WsnBraceletInfoService wsnBraceletInfoService;
    
    NowTime nowtTime=new NowTime();
    
    
    @RequestMapping("/collect/shangchuan")
    public String showChartMain1(Model model) {
       // wsnHardwareInfoService.findSensorByType(i)
        return "stat/cloud_host_import";
    }
    /**
     * 云主机批量导入Excel
     * 
     * @param model
     * @return
     */
    @RequestMapping("/host/import")
    @ResponseBody
    public Map<String, Object> importHostData(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        List<List<Double>> results = new ArrayList<>();// 存放中间结果
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.
                findWsnHardwareInfoByWare("SEN_WD01_001");  // 获取温度的阈值
        Double tempAlarm = Double.parseDouble(wsnHardwareInfo.getInfoFour());
        WsnHardwareInfo wsnHardwareInfo2 = wsnHardwareInfoService.
                findWsnHardwareInfoByWare("SEN_YQ01_001");   // 获取氧气的阈值
        Double OxygenAlarm = Double.parseDouble(wsnHardwareInfo2.getInfoFour());
        if (!file.isEmpty()) {
            try {
                InputStream inputStream = file.getInputStream();
                Workbook wb = WorkbookFactory.create(inputStream);
                
                Sheet sh1 = wb.getSheetAt(0);  // 第一张表，危险物料
                HSSFRow ro=null;
                List<Double> hazardousResult = new ArrayList<>();
                for (int i = 1; sh1.getRow(i)!=null; i++) {
                      // 保存每一条的结果，一条算出一个值。
                    ro=(HSSFRow) sh1.getRow(i);
                    Double rowCount = 0.00;
                    for (int j = 2; ro.getCell(j)!=null; j+=2) {
                        rowCount += Double.parseDouble(ro.getCell(j-1).toString()) * 
                                Double.parseDouble(ro.getCell(j).toString());
                    }
                    hazardousResult.add(rowCount * Double.parseDouble(ro.getCell(0).toString()));
                }
                results.add(hazardousResult); //第一张表危险物料的计算结果放在list中
                
                Sheet sh2 = wb.getSheetAt(1);  // 第二张表 工艺参数
                HSSFRow ro2 = null;
                HSSFRow titleRow = (HSSFRow) sh2.getRow(0); // 查找第二张表的表头，查出温度、压力、氧气的值
                int tempRow =0;
                int pressRow =0;
                int oxygenRow = 0;
                for(int i=0;titleRow.getCell(i)!=null;i++){
                    if(titleRow.getCell(i).toString().equals("温度权重")){
                        tempRow = i;
                    }else if(titleRow.getCell(i).toString().equals("压力权重")){
                        pressRow = i;
                    }else if(titleRow.getCell(i).toString().equals("氧含量权重")){
                        oxygenRow = i;
                    }else {
                        continue;
                    }
                }
                HSSFRow rHssfRow = null;
                for(int i=1;sh2.getRow(i)!=null;i++){   // 修改第二张表中温度 压力 氧气的列值
                    rHssfRow = (HSSFRow) sh2.getRow(i);
                    for(int j=0;rHssfRow.getCell(j)!=null;j++){
                        if(j == tempRow){
                           Double temp = Double.parseDouble(rHssfRow.getCell(j).toString())/tempAlarm;
                           rHssfRow.getCell(j).setCellValue(temp);
                        }else if (j == pressRow) {
                            Double press = calPress(Double.parseDouble(rHssfRow.getCell(j).toString()));
                            rHssfRow.getCell(j).setCellValue(press);
                        }else if (j == oxygenRow) {
                            double oxygen = Double.parseDouble(rHssfRow.getCell(j).toString())/OxygenAlarm;
                            rHssfRow.getCell(j).setCellValue(oxygen);
                        }else {
                            double other = Double.parseDouble(rHssfRow.getCell(j).toString());
                            rHssfRow.getCell(j).setCellValue(other);
                        }
                    }
                }
               
                List<Double> technology = new ArrayList<Double>();  // 第二章表的计算
                for(int i = 1;sh2.getRow(i)!=null ;i++){
                    ro2 = (HSSFRow) sh2.getRow(i);
                    Double row2Count = 0.00;
                    for(int j=2;ro2.getCell(j)!=null;j+=2){
                        row2Count += Double.parseDouble(ro2.getCell(j-1).toString())*
                                Double.parseDouble(ro2.getCell(j).toString());
                    }
                    technology.add(row2Count * Double.parseDouble(ro2.getCell(0).toString()));
                }
                results.add(technology);
                
                Sheet sh3 = wb.getSheetAt(2);  //第三张 安全控制
                HSSFRow ro3 = null;
                List<Double>control = new ArrayList<Double>();
                for(int i =1 ;sh3.getRow(i)!=null;i++){
                    ro3 = (HSSFRow) sh3.getRow(i);
                    Double row3Count = 0.00;
                    for(int j =2;ro3.getCell(j)!=null;j+=2){
                        row3Count += Double.parseDouble(ro3.getCell(j-1).toString()) * 
                                Double.parseDouble(ro3.getCell(j).toString());
                    }
                    control.add(row3Count * Double.parseDouble(ro3.getCell(0).toString()));
                }
                results.add(control);   // 计算的结果存在result中，
                int rowNum = sh1.getLastRowNum();
                List<Double> reDoubles = new ArrayList<Double>(); // 最终结果，每一条的最终值
                for(int i=0;i<rowNum;i++){
                    double tempp =0;
                    for (List<Double> rs : results) {
                        tempp += rs.get(i);
                    }
                    reDoubles.add(tempp);
                }
                /**
                 * 1. 最终结果中计算值评价指标
                 * 高度危险 ：0.84以上
                 * 一般危险：0.71-0.84
                 * 比较危险：0.5-0.71
                 * 可能危险：0-0.5
                 * 
                 */
                wb.close();
                map.put("LastResults", reDoubles);   // 最终每条的评估结果
                map.put("Midresults", results);        // 每条结果中中间结果，每一部分的权值
                map.put("status", "1");
                map.put("info", "文件上传解析成功！");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("status", "0");
                map.put("error", "文件上传失败！" + e.getMessage());
            }
        }else {
            map.put("status", "0");
            map.put("error", "请选择需要上传的文件！");
        }
        return map;
    }
    
    // 计算压力值
    public static double calPress(Double press) {
        double p = (press/1000);
        return 0.16109 + 1.61503 * p - Math.pow(p, 2)*1.42879 + Math.pow(p, 3)*0.5172 ;
        
    }
    
    @RequestMapping("/index")
    public String showChartMain(Model model) {
       // wsnHardwareInfoService.findSensorByType(i)
        return "stat/stat_index1";
    }
    
    @RequestMapping("/list_index")
    public String showListIndex(Model model) {
       
        List<WsnMonitorObj>wsnMonitorObjServices= wsnMonitorObjService.findAllWsnMonitorObj();
        
        model.addAttribute("objList", wsnMonitorObjServices);
        return "stat/stat_list_index";
    }
    
    //数据采集
    @RequestMapping("/collect")
    public String showCollectPage(Model model) {
        //List<WsnCollectSts> wsnCollectSts = wsnBraceletInfoService.findCollect();
        List<WsnTray> wsntray=wsnBraceletInfoService.FindCollect();//接口中加了方法
        WsnCollectSts wsnCollectSts2 = new WsnCollectSts();//作为单独的javaBean进行
        
        if(nowtTime.compareTime(wsntray.get(3).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn1Sts1(1);}
        else{wsnCollectSts2.setMn1Sts1(0);
           Collection.node[0]=0; 
        } 
        if(nowtTime.compareTime(wsntray.get(4).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn2Sts2(1);}
        else{wsnCollectSts2.setMn2Sts2(0);
           Collection.node[1]=0;
        }          
        if(nowtTime.compareTime(wsntray.get(5).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn3Sts3(1);}
        else{wsnCollectSts2.setMn3Sts3(0);
           Collection.node[2]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(6).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn4Sts4(1);}
        else{wsnCollectSts2.setMn4Sts4(0);
           Collection.node[3]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(7).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn5Sts5(1);}
        else{wsnCollectSts2.setMn5Sts5(0);
           Collection.node[4]=0;
        }
        if(nowtTime.compareTime(wsntray.get(8).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setMn6Sts6(1);}
        else{wsnCollectSts2.setMn6Sts6(0);
           Collection.node[5]=0;
        } 
        if(nowtTime.compareTime(wsntray.get(0).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setKcd11(1);}
        else{wsnCollectSts2.setKcd11(0);
           Collection.node2[0]=0;
        }
        if(nowtTime.compareTime(wsntray.get(1).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts2.setKcd22(1);}
        else{wsnCollectSts2.setKcd22(0);
           Collection.node2[1]=0;
        } 
        wsnCollectSts2.setMn1Sts(Collection.node[0]);
        wsnCollectSts2.setMn2Sts(Collection.node[1]);
        wsnCollectSts2.setMn3Sts(Collection.node[2]);
        wsnCollectSts2.setMn4Sts(Collection.node[3]);
        wsnCollectSts2.setMn5Sts(Collection.node[4]);
        wsnCollectSts2.setMn6Sts(Collection.node[5]);
        wsnCollectSts2.setWsnSts(Collection.database[0]);
        wsnCollectSts2.setRfidSts(Collection.database[1]);
        wsnCollectSts2.setKcd1(Collection.node2[0]);
        wsnCollectSts2.setKcd2(Collection.node2[1]);
        model.addAttribute("sts", wsnCollectSts2);
        return "collect/collection_page";
    }
    @RequestMapping("/camrea")
    public String showCamreaPage(Model model) {
        
        return "collect/camrea_page";
    }
   
    
    /**
     * 断开
     * @param model
     * @param wsn
     * @param rfid
     * @param mn1
     * @param mn2
     * @param mn3
     * @param mn4
     * @param mn5
     * @param mn6
     * @return
     */
    @RequestMapping("/disconnect")
    public String disconncetPage(Model model ,int wsn,int rfid,int mn1,int mn2,int mn3,int mn4,int mn5,int mn6,int kcd1,int kcd2){
        if(wsn!=2){
            Collection.database[0]=wsn;}
            if(rfid!=2){
            Collection.database[1]=rfid;}
            if(mn1!=2){
            Collection.node[0]=mn1;}
            if(mn2!=2){
            Collection.node[1]=mn2;}
            if(mn3!=2){
            Collection.node[2]=mn3;}
            if(mn4!=2){
            Collection.node[3]=mn4;}
            if(mn5!=2){
            Collection.node[4]=mn5;}
            if(mn6!=2){
            Collection.node[5]=mn6;}
            if(kcd1!=2){
                Collection.node2[0]=kcd1;}
            if(kcd2!=2){
                Collection.node2[1]=kcd2;}
        if (Collection.database[0] == 0 && Collection.database[1] == 0) {
            /*mn1=0;
            mn2=0;
            mn3=0;
            mn4=0;
            mn5=0;
            mn6=0;*/
            Collection.node[0]=0;
            Collection.node[1]=0;
            Collection.node[2]=0;
            Collection.node[3]=0;
            Collection.node[4]=0;
            Collection.node[5]=0;
            Collection.node2[0]=0;
            Collection.node2[1]=0;
        }
        WsnCollectSts wsnCollectSts = new WsnCollectSts();
        wsnCollectSts.setMn1Sts(Collection.node[0]);
        wsnCollectSts.setMn2Sts(Collection.node[1]);
        wsnCollectSts.setMn3Sts(Collection.node[2]);
        wsnCollectSts.setMn4Sts(Collection.node[3]);
        wsnCollectSts.setMn5Sts(Collection.node[4]);
        wsnCollectSts.setMn6Sts(Collection.node[5]);
        wsnCollectSts.setWsnSts(Collection.database[0]);
        wsnCollectSts.setRfidSts(Collection.database[1]);
        wsnCollectSts.setKcd1(Collection.node2[0]);
        wsnCollectSts.setKcd2(Collection.node2[1]);
        List<WsnTray> wsntray=wsnBraceletInfoService.FindCollect();//接口中加了方法
        if(nowtTime.compareTime(wsntray.get(3).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn1Sts1(1);}
        else{wsnCollectSts.setMn1Sts1(0);
           Collection.node[0]=0; 
        } 
        if(nowtTime.compareTime(wsntray.get(4).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn2Sts2(1);}
        else{wsnCollectSts.setMn2Sts2(0);
           Collection.node[1]=0;
        }          
        if(nowtTime.compareTime(wsntray.get(5).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn3Sts3(1);}
        else{wsnCollectSts.setMn3Sts3(0);
           Collection.node[2]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(6).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn4Sts4(1);}
        else{wsnCollectSts.setMn4Sts4(0);
           Collection.node[3]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(7).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn5Sts5(1);}
        else{wsnCollectSts.setMn5Sts5(0);
           Collection.node[4]=0;
        }
        if(nowtTime.compareTime(wsntray.get(8).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn6Sts6(1);}
        else{wsnCollectSts.setMn6Sts6(0);
           Collection.node[5]=0;
        } 
        if(nowtTime.compareTime(wsntray.get(0).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setKcd11(1);}
        else{wsnCollectSts.setKcd11(0);
           Collection.node2[0]=0;
        }
        if(nowtTime.compareTime(wsntray.get(1).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setKcd22(1);}
        else{wsnCollectSts.setKcd22(0);
           Collection.node2[1]=0;
        } 
        model.addAttribute("sts", wsnCollectSts);
        return "collect/collection_page";
        //return null;
    }
    
    
    /**
     * 选择list表
     * @param mntProdRelPlan
     * @return Map<String, Object>
     */
    @RequestMapping("/list/query")
    @ResponseBody
    public Map<String, Object> getWsnInfoList(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfo.setTypeId(1);
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findWsnHardwareInfoList(wsnHardwareInfo);
    //    List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoService.findSensorByType(1);
        for (int i = 0; i < wsnHardwareInfos.size(); i++) {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            wsnHardwareInfos.get(i).setInfoFive(dateString);
            //到视图总拿
            String newData = wsnSensorService.findNewDataById(wsnHardwareInfos.get(i).getWareId());
            //DecimalFormat dcmFmt = new DecimalFormat("00.0");
            //wsnHardwareInfos.get(i).setInfoFour(String.valueOf(dcmFmt.format(Math.random()*30)));
            // 找到该传感器的最新值到各个数据表中取
            //String newData = wsnSensorService.findDate(wsnHardwareInfos.get(i).getWareId());
            //赋值给infoFour
            
            wsnHardwareInfos.get(i).setInfoFour(newData);
          
            if (wsnHardwareInfos.get(i).getTypeId() == 1) {
                wsnHardwareInfos.get(i).setTypeTxt("传感器");
            }
            
        }
        
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHardwareInfos);
        map.put("status", "1");
        return map;
    }
    
    @RequestMapping("/hardware/query")
    public Map<String, Object>getDeviceList(){
         List<WsnHardwareInfo>deviceList= wsnHardwareInfoService.findAllWsnHardwareInfo();
         Map<String, Object> map = new HashMap<>();
         map.put("data", deviceList);
         map.put("status", "1");
         return map;
    }
    
    
    @RequestMapping("/connect")
    public String conncetPage(Model model ,int wsn,int rfid,int mn1,int mn2,int mn3,int mn4,int mn5,int mn6,int kcd1,int kcd2){
        if(wsn!=2){
            Collection.database[0]=wsn;}
            if(rfid!=2){
            Collection.database[1]=rfid;}
            if(mn1!=2){
            Collection.node[0]=mn1;}
            if(mn2!=2){
            Collection.node[1]=mn2;}
            if(mn3!=2){
            Collection.node[2]=mn3;}
            if(mn4!=2){
            Collection.node[3]=mn4;}
            if(mn5!=2){
            Collection.node[4]=mn5;}
            if(mn6!=2){
            Collection.node[5]=mn6;}
            if(kcd1!=2){
                Collection.node2[0]=kcd1;}
            if(kcd2!=2){
                Collection.node2[1]=kcd2;}
            if (Collection.database[0] == 0 && Collection.database[1] == 0) {
                /*mn1=0;
                mn2=0;
                mn3=0;
                mn4=0;
                mn5=0;
                mn6=0;*/
                Collection.node[0]=0;
                Collection.node[1]=0;
                Collection.node[2]=0;
                Collection.node[3]=0;
                Collection.node[4]=0;
                Collection.node[5]=0;
                Collection.node2[0]=0;
                Collection.node2[1]=0;
            }
        WsnCollectSts wsnCollectSts = new WsnCollectSts();
        wsnCollectSts.setMn1Sts(Collection.node[0]);
        wsnCollectSts.setMn2Sts(Collection.node[1]);
        wsnCollectSts.setMn3Sts(Collection.node[2]);
        wsnCollectSts.setMn4Sts(Collection.node[3]);
        wsnCollectSts.setMn5Sts(Collection.node[4]);
        wsnCollectSts.setMn6Sts(Collection.node[5]);
        wsnCollectSts.setWsnSts(Collection.database[0]);
        wsnCollectSts.setRfidSts(Collection.database[1]);
        wsnCollectSts.setKcd1(Collection.node2[0]);
        wsnCollectSts.setKcd2(Collection.node2[1]);
        List<WsnTray> wsntray=wsnBraceletInfoService.FindCollect();//接口中加了方法
        if(nowtTime.compareTime(wsntray.get(3).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn1Sts1(1);}
        else{wsnCollectSts.setMn1Sts1(0);
           Collection.node[0]=0; 
        } 
        if(nowtTime.compareTime(wsntray.get(4).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn2Sts2(1);}
        else{wsnCollectSts.setMn2Sts2(0);
           Collection.node[1]=0;
        }          
        if(nowtTime.compareTime(wsntray.get(5).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn3Sts3(1);}
        else{wsnCollectSts.setMn3Sts3(0);
           Collection.node[2]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(6).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn4Sts4(1);}
        else{wsnCollectSts.setMn4Sts4(0);
           Collection.node[3]=0;
        }    
        if(nowtTime.compareTime(wsntray.get(7).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn5Sts5(1);}
        else{wsnCollectSts.setMn5Sts5(0);
           Collection.node[4]=0;
        }
        if(nowtTime.compareTime(wsntray.get(8).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setMn6Sts6(1);}
        else{wsnCollectSts.setMn6Sts6(0);
           Collection.node[5]=0;
        } 
        if(nowtTime.compareTime(wsntray.get(0).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setKcd11(1);}
        else{wsnCollectSts.setKcd11(0);
           Collection.node2[0]=0;
        }
        if(nowtTime.compareTime(wsntray.get(1).getWareTime(),nowtTime.getTime())=="true"){wsnCollectSts.setKcd22(1);}
        else{wsnCollectSts.setKcd22(0);
           Collection.node2[1]=0;
        } 
        model.addAttribute("sts", wsnCollectSts);
        return "collect/collection_page";
        //return null;
    }
    /*@RequestMapping("/req/prod/{type}")
    @ResponseBody
    public HighChartInstance getStatResForBaseId(MntReleaseRec mntReleaseRec, @PathVariable String type) {
        
        mntReleaseRec.setBeginDate(DateUtil.getMonthBegin(mntReleaseRec.getBeginDate()));
        mntReleaseRec.setEndDate(DateUtil.getMonthEnd(mntReleaseRec.getBeginDate()));
        mntReleaseRec.setDeleteFlag("0");
        List<MntReleaseRec> statList = new ArrayList<>();
        
        String _title = "";
        if("1".equals(type)) {
            statList = mntReleaseRecService.getStatResForProdId(mntReleaseRec);
            _title = "各产品发布需求量统计";
        }else {
            statList = mntReleaseRecService.getStatResForBaseId(mntReleaseRec);
            _title = "各安装点发布需求量统计";
        }
        
        HighChartInstance hchart = new HighChartInstance();
        
        Chart chart = new Chart();
        chart.setType("column");
        chart.setRenderTo("container");
        
        DateFormat df = new SimpleDateFormat("yyyy年MM月");
        String yearmonth = df.format(mntReleaseRec.getBeginDate());
        
        Title title = new Title();
        title.setText(yearmonth + _title);

        Legend legend = new Legend();
        legend.setEnabled(false);
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        //Y轴
        YAxis yAxis = new YAxis();
        Title ytitle = new Title();
        ytitle.setText("发布需求数量(个)");
        yAxis.setTitle(ytitle);
        
        //X轴
        XAxis xAxis = new XAxis();
        String[] categories = new String[statList.size()];
        xAxis.setCategories(categories);
        
        //数据
        List<Series> seriesList = new ArrayList<>();
        Series series = new Series();
        series.setName("需求数量");
        
        int[] data = new int[statList.size()];
        
        for(int i=0; i<statList.size(); i++) {
            MntReleaseRec temp = statList.get(i);
            if("1".equals(type)) {
                categories[i] = temp.getProdName();
            }else if("2".equals(type)) {
                categories[i] = temp.getBaseName();
            }
            data[i] = temp.getDtlCount();
        }
        
        series.setData(data);
        seriesList.add(series);
        
        hchart.setChart(chart);
        hchart.setLegend(legend);
        hchart.setSeries(seriesList);
        hchart.setTitle(title);
        hchart.setxAxis(xAxis);
        hchart.setyAxis(yAxis);
        
        return hchart;
    }
    
    *//**
     * 上线日历展示
     * @param mntReleaseRec
     * @param type
     * @return
     *//*
    @RequestMapping("/online/calendar")
    @ResponseBody
    public List<FullCalendar> getOnlineRec(FullCalendar fullCalendar) {
        MntInstallOnlineInfo mntInstallOnlineInfo = new MntInstallOnlineInfo();
        mntInstallOnlineInfo.setBeginDate(DateUtil.stringToDateShort(fullCalendar.getStart()));
        mntInstallOnlineInfo.setEndDate(DateUtil.stringToDateShort(fullCalendar.getEnd()));
        List<MntInstallOnlineInfo> onlineInfoList = mntInstallOnlineInfoService.getDistinctOnlineDateList(mntInstallOnlineInfo);
        
        List<FullCalendar> fullCalendarList = new ArrayList<>();
        for(MntInstallOnlineInfo temp : onlineInfoList) {
            fullCalendar = new FullCalendar();
            fullCalendar.setId(DateUtil.dateToStringShort(temp.getOnlineDate()));
            fullCalendar.setTitle("上线");
            fullCalendar.setStart(DateUtil.dateToStringShort(temp.getOnlineDate()));
            fullCalendar.setEnd(DateUtil.dateToStringShort(temp.getOnlineDate()));
//            String day = DateUtil.getDay(temp.getOnlineDate());
//            int d = Integer.parseInt(day) % 10;//取个位数字 固定颜色
            fullCalendar.setColor("#FF7256");
            fullCalendarList.add(fullCalendar);
        }
        return fullCalendarList;
    }
    
    @RequestMapping("/online/list/{onlineDate}")
    public String showOnlineRecPage(@PathVariable String onlineDate, Model model) {
        model.addAttribute("onlineDate", onlineDate);
        return "stat/inst_online_list";
    }*/
}
