package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnGeteway 
 * @Description: WsnGeteway Model
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */
public class WsnGeteway implements Serializable{

    private static final long serialVersionUID = 1L;

    /**网关IP*/
    private Integer gatewayId;

    /**网关名称*/
    private String gatewayName;

    /**网管ip*/
    private String gatewayIp;

    /**备注*/
    private String remark;


    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}