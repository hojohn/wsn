package com.b510.tray; 

import java.util.Calendar;
import java.util.GregorianCalendar;

public class NowTime {//或许当前时间
	public String getTime(){
		String time="";
	    Calendar cal = new GregorianCalendar();
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH)+1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);  // 24小时制
	    int minute = cal.get(Calendar.MINUTE);
	    int second = cal.get(Calendar.SECOND);
	    String h,m,s;
	    if(hour<10) h = "0"+hour; else h = hour+"";
	    if(minute<10) m = "0"+minute; else m = minute+"";
	    if(second<10) s = "0"+second; else s = second+"";
	    time=year+"-"+month+"-"+day+" "+h+":"+m+":"+s;
	    return  time;
}
	public String compareTime(String time,String time2){
        String[] param=time.trim().split(" ");
        String[] param2=time2.trim().split(" ");
        String[] param3=param[1].split(":");
        String[] param4=param2[1].split(":");
        String[] param5=param[0].trim().split("-");
        String[] param6=param2[0].trim().split("-");
        String param7=Integer.parseInt(param5[0])+"-"+Integer.parseInt(param5[1])+"-"+Integer.parseInt(param5[2]);
        String param8=Integer.parseInt(param6[0])+"-"+Integer.parseInt(param6[1])+"-"+Integer.parseInt(param6[2]);
        if(!param7.equals(param8)){
            return "false";}
        if(!param3[0].equals(param4[0])){
            return "false";}
        if((Integer.parseInt(param4[1])-Integer.parseInt(param3[1])<=5)&&(Integer.parseInt(param4[1])-Integer.parseInt(param3[1])>0)){
            if((Integer.valueOf(param4[1])-Integer.valueOf(param3[1]))==5){
                if(Double.parseDouble(param4[2])<=Double.parseDouble(param3[2])){
                    return "true";
                }else{
                    return "false";
                }
            }
            return "true";
        }
        if(Integer.parseInt(param4[1])-Integer.parseInt(param3[1])==0&&Double.parseDouble(param4[2])-Double.parseDouble(param3[2])>=0){
            return "true";
        }
        else{
         return "false";
        }
        
                   }
	}