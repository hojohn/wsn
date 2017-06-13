package com.ai.mnt.web.collect;


import java.text.DecimalFormat;//修改了数据库设计表的value大小

public class read_CH4_Consentration {
	final double CH4_Consentration[]={3.08,2.65,2.335,2.2857,2.1429,2,1.91667,1.86667,1.83333,1.45,1.24167,1.075,0.93,0.897,0.8,0.78,0.72,0.7};
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	public	String read_CH4_Consentration(double ratio)
	{
	    float Consentration;
	    if(ratio>CH4_Consentration[0]) return  0.0+"";
	    if(ratio<CH4_Consentration[17]) return  11000.0+"";
	    int i=0;
	    while( ratio<CH4_Consentration[i]) i++;
	    if(i<=8)
	    {
	      Consentration = (float) (200+(i-1)*100+100*(CH4_Consentration[i-1]-ratio)/(CH4_Consentration[i-1]-CH4_Consentration[i]));
	      return df.format(Consentration)+"";
	    }
	    else if(i<18)
	   {
	      Consentration = (float) (1000+(i-8)*1000+1000*(CH4_Consentration[i-1]-ratio)/(CH4_Consentration[i-1]-CH4_Consentration[i]));
	      return df.format(Consentration)+"";
	   }
      return "0";
	}

}
