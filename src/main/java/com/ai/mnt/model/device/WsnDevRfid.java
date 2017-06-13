package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnDevRfid 
 * @Description: WsnDevRfid Model
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */
public class WsnDevRfid implements Serializable{

    private static final long serialVersionUID = 1L;

    /**标签设备关联ID*/
    private Integer rfDevId;

    /**标签ID*/
    private Integer rfidId;

    /**设备ID*/
    private Integer deviceId;


    public Integer getRfDevId() {
        return rfDevId;
    }

    public void setRfDevId(Integer rfDevId) {
        this.rfDevId = rfDevId;
    }

    public Integer getRfidId() {
        return rfidId;
    }

    public void setRfidId(Integer rfidId) {
        this.rfidId = rfidId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }


}