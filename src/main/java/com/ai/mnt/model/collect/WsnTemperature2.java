package com.ai.mnt.model.collect;

import java.io.Serializable; 

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Title: WsnTemperature 
 * @Description: WsnTemperature Model
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
public class WsnTemperature2 implements Serializable{

    private static final long serialVersionUID = 1L;

    /**传感器编号*/
    private String wareId;

    /**网关*/
    private String objId;

    /**传感器温度值*/
    private String temperatureValue;

    /**频率*/
    private String rate;

    /**状态：0正常，1损坏，2丢失*/
    private Integer state;

    /**采集时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    /**备用*/
    private String field;

    /**主键*/
    private Integer id;

    //均值
    private String avg;

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(String temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }


}