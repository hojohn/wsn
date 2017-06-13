package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnSensor 
 * @Description: WsnSensor Model
 * @Author: Auto Generate.
 * @Date: 2016-10-30
 */
public class WsnSensor implements Serializable{

    private static final long serialVersionUID = 1L;

    /**记录id*/
    private Integer id;

    /**温度传感器ID*/
    private Integer temperatureId;

    /**湿度传感器ID*/
    private Integer humidityId;

    /**粉尘传感器ID*/
    private Integer dustId;

    /**噪声传感器ID*/
    private Integer noiseId;

    /**温度值*/
    private String temperature;

    /**湿度值*/
    private String humidity;

    /**粉尘值*/
    private String dust;

    /**噪音值*/
    private String noise;

    /**采集时间*/
    private String createTime;

    /**频率*/
    private Integer rate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(Integer temperatureId) {
        this.temperatureId = temperatureId;
    }

    public Integer getHumidityId() {
        return humidityId;
    }

    public void setHumidityId(Integer humidityId) {
        this.humidityId = humidityId;
    }

    public Integer getDustId() {
        return dustId;
    }

    public void setDustId(Integer dustId) {
        this.dustId = dustId;
    }

    public Integer getNoiseId() {
        return noiseId;
    }

    public void setNoiseId(Integer noiseId) {
        this.noiseId = noiseId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDust() {
        return dust;
    }

    public void setDust(String dust) {
        this.dust = dust;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }


}