package com.ai.mnt.web.collect;

import java.text.DecimalFormat;

public class read_CO_Consentration {
	final double CO_Consentration[]={1.66667,1.36667,1.25,1.2,0.99,0.905,0.86,0.815,0.79};
	DecimalFormat    df   = new DecimalFormat("######0.00");   
	public String read_CO_Consentration(double ratio)
	{
	    float Consentration;
	    if(ratio>CO_Consentration[0]) return 0.0+"";
	    if(ratio<CO_Consentration[8]) return 1100.0+"";
	    int i=0;
	    while( ratio<CO_Consentration[i]) i++;
	    if(i<=8)
	    {
	      Consentration = (float) (200+(i-1)*100+100*(CO_Consentration[i-1]-ratio)/(CO_Consentration[i-1]-CO_Consentration[i]));
	      return df.format(Consentration)+"";
	    }
	    return "0";
	}
	
}
