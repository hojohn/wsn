package com.ai.mnt.web.debug;
import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class SigarUtils {
    private Sigar sigar;
    public SigarUtils(Sigar Sigar){
        sigar=Sigar;
    }
   public List<Double> CPU() throws SigarException{
    CpuInfo info[]=sigar.getCpuInfoList();
    CpuPerc cpuList[]=sigar.getCpuPercList();
    double cpu[]=new double[info.length];
    double finaCpu=0;
    long finahuancun=0;
    long huancun[]=new long[info.length];
    for(int i=0;i<info.length;i++){
        huancun[i]=info[i].getCacheSize();
        cpu[i]=cpuperc(cpuList[i]);
    }
    for(double cc:cpu)
      finaCpu+=cc;
    for(long huancun1:huancun)
        finahuancun+=huancun1;
    double cpu2=finaCpu/(cpu.length);
    double fin=finahuancun/(huancun.length);
    List<Double> fina=new ArrayList<Double>();
    fina.add(cpu2);
    fina.add(fin);
    return fina;
   }
   public double cpuperc(CpuPerc cpu){
       return cpu.getCombined();
   }
   
}