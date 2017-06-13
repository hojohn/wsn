package com.ai.mnt.web.debug;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class networkCard {
    private Sigar sigar;
    private String IP;
 public networkCard(Sigar sigar1,String ip){
     sigar=sigar1;
     IP=ip;
 }
 public Map<String,Object> getWangka() throws SigarException{
     Map<String, Object> map=new HashMap<String, Object>();
     String ifNames[] = sigar.getNetInterfaceList();
     
     for (int i = 0; i < ifNames.length; i++) {
         NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames[i]);
         NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames[i]);
         if(ifconfig.getAddress().trim().equals(IP)){
             if(ifstat.getTxErrors()!=0){
             Long error=(ifstat.getTxErrors())/(ifstat.getTxBytes());
             Long lose=(ifstat.getRxDropped())/(ifstat.getTxBytes());
             System.out.println(error+"*****************"+lose);
             map.put("error", error);
             map.put("lose", lose);}else{
                 map.put("error", 0);
                 map.put("lose", 0);
             }
             
         }
     }
     return map;
 }
}
