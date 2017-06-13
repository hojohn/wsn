package com.ai.mnt.web.debug;

import java.math.BigDecimal;   
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.mnt.service.device.WsnHardwareInfoService;

@Controller
@RequestMapping("/debug")
public class Debug {
    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
    
    
    
    @RequestMapping("/dandian/page")
    public String dandianPage(Model model){
        List<Map<String,Object>> wsnMonitorObjList=wsnHardwareInfoService.findAllWsnDebugInfo(3);
        List<Map<String,Object>> stateList=wsnHardwareInfoService.state(wsnMonitorObjList);//拿到ping的结果
        model.addAttribute("wsnHardwareInfo", stateList);
        return "wsn_device/tiaoshi/dandianpage";
    }
    @RequestMapping("/tongxun/page")
    public String tongxunPage(Model model) throws UnknownHostException, SigarException{
        Map<String,Object> wsnServerList=new HashMap<String,Object>();
        Properties p=System.getProperties();
        Map<String, String> map = System.getenv();
        Sigar sigar = new Sigar();
        Mem  mem = sigar.getMem();
        double memery=(double)(mem.getUsed() / 1024)/( mem.getTotal() / 1024);
        double JVM=(double)(((int)Runtime.getRuntime().totalMemory())-((int)Runtime.getRuntime().freeMemory()))/((int) Runtime.getRuntime().totalMemory());
        BigDecimal   b   =   new   BigDecimal(JVM);  
        BigDecimal   b1   =   new   BigDecimal(memery);
        double   f  =   b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        double   f1 =   b1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        String Jvm=(f*100)+"%";//JVM内存占用比
        String Memery=(f1*100)+"%";//内存使用率
        String sysName=p.getProperty("os.name");
        String javaVisul=p.getProperty("java.vm.name");
        String version=sysName+"."+p.getProperty("os.version");//操作系统版本
        String name=map.get("USERNAME");//服务器名称
        InetAddress addr= InetAddress.getLocalHost();
        String IP = addr.getHostAddress();//服务器IP地址
        SigarUtils sutils=new SigarUtils(sigar);
        List<Double> cpu=sutils.CPU();
        BigDecimal   b2   =   new   BigDecimal(cpu.get(0));
        double   f2  =   b2.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal   b3   =   new   BigDecimal(cpu.get(1));
        double   f3  =   b3.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        String Cpu=(f2*100)+"%";
        String cpuhuancun=(f3)+"";
        networkCard net=new networkCard(sigar,"127.0.0.1");
        Map<String,Object> bagMap=net.getWangka();
        wsnServerList.put("name", name);
        wsnServerList.put("memery", Memery);
        wsnServerList.put("JVM", Jvm);
        wsnServerList.put("version", version);
        wsnServerList.put("IP", IP);
        wsnServerList.put("cpu", Cpu);
        wsnServerList.put("javaVisual", javaVisul);
        wsnServerList.put("error", bagMap.get("error")+"%");
        wsnServerList.put("lose", bagMap.get("lose")+"%");
        wsnServerList.put("huancun", cpuhuancun);
        model.addAttribute("wsnHardwareInfo", wsnServerList);
        return "wsn_device/tiaoshi/breakdown";
    }
}
