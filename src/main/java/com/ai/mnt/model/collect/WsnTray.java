package com.ai.mnt.model.collect;

import java.io.Serializable; 

/**
 * @Title: WsnTray 
 * @Description: WsnTray Model
 * @Author: Auto Generate.
 * @Date: 2017-4-25
 */
public class WsnTray implements Serializable{

    private static final long serialVersionUID = 1L;

    /**主键*/
    private String wareId;

    /**时间*/
    private String wareTime;


    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getWareTime() {
        return wareTime;
    }

    public void setWareTime(String wareTime) {
        this.wareTime = wareTime;
    }


}