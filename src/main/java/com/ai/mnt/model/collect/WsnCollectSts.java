package com.ai.mnt.model.collect;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnCollectSts 
 * @Description: WsnCollectSts Model
 * @Author: Auto Generate.
 * @Date: 2017-3-10
 */
public class WsnCollectSts implements Serializable{

    private static final long serialVersionUID = 1L;

    /***/
    private Integer id;

    /**wsn_dev数据库状态*/
    private Integer wsnSts;

    /**RFID数据库状态*/
    private Integer rfidSts;

    /**移动节点1*/
    private Integer mn1Sts;

    /**移动节点2*/
    private Integer mn2Sts;

    /**移动节点3*/
    private Integer mn3Sts;

    /**移动节点4*/
    private Integer mn4Sts;

    /**移动节点5*/
    private Integer mn5Sts;

    /**移动节点6*/
    private Integer mn6Sts;
    private Integer kcd1;
    private Integer kcd2;

    public Integer getKcd1() {
        return kcd1;
    }

    public void setKcd1(Integer kcd1) {
        this.kcd1 = kcd1;
    }

    public Integer getKcd2() {
        return kcd2;
    }

    public void setKcd2(Integer kcd2) {
        this.kcd2 = kcd2;
    }

    

    /**备用*/
    private Integer status;
    /**代表移动节点连接服务器状态*/
    private Integer mn1Sts1;
    private Integer mn2Sts2;
    private Integer mn3Sts3;
    private Integer mn4Sts4;
    private Integer mn5Sts5;
    private Integer mn6Sts6;
    

    public Integer getMn1Sts1() {
        return mn1Sts1;
    }

    public void setMn1Sts1(Integer mn1Sts1) {
        this.mn1Sts1 = mn1Sts1;
    }

    public Integer getMn2Sts2() {
        return mn2Sts2;
    }

    public void setMn2Sts2(Integer mn2Sts2) {
        this.mn2Sts2 = mn2Sts2;
    }

    public Integer getMn3Sts3() {
        return mn3Sts3;
    }

    public void setMn3Sts3(Integer mn3Sts3) {
        this.mn3Sts3 = mn3Sts3;
    }

    public Integer getMn4Sts4() {
        return mn4Sts4;
    }

    public void setMn4Sts4(Integer mn4Sts4) {
        this.mn4Sts4 = mn4Sts4;
    }

    public Integer getMn5Sts5() {
        return mn5Sts5;
    }

    public void setMn5Sts5(Integer mn5Sts5) {
        this.mn5Sts5 = mn5Sts5;
    }

    public Integer getMn6Sts6() {
        return mn6Sts6;
    }

    public void setMn6Sts6(Integer mn6Sts6) {
        this.mn6Sts6 = mn6Sts6;
    }
    private Integer kcd11;
    private Integer kcd22;
    public Integer getKcd11() {
        return kcd11;
    }

    public void setKcd11(Integer kcd11) {
        this.kcd11 = kcd11;
    }

    public Integer getKcd22() {
        return kcd22;
    }

    public void setKcd22(Integer kcd22) {
        this.kcd22 = kcd22;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWsnSts() {
        return wsnSts;
    }

    public void setWsnSts(Integer wsnSts) {
        this.wsnSts = wsnSts;
    }

    public Integer getRfidSts() {
        return rfidSts;
    }

    public void setRfidSts(Integer rfidSts) {
        this.rfidSts = rfidSts;
    }

    public Integer getMn1Sts() {
        return mn1Sts;
    }

    public void setMn1Sts(Integer mn1Sts) {
        this.mn1Sts = mn1Sts;
    }

    public Integer getMn2Sts() {
        return mn2Sts;
    }

    public void setMn2Sts(Integer mn2Sts) {
        this.mn2Sts = mn2Sts;
    }

    public Integer getMn3Sts() {
        return mn3Sts;
    }

    public void setMn3Sts(Integer mn3Sts) {
        this.mn3Sts = mn3Sts;
    }

    public Integer getMn4Sts() {
        return mn4Sts;
    }

    public void setMn4Sts(Integer mn4Sts) {
        this.mn4Sts = mn4Sts;
    }

    public Integer getMn5Sts() {
        return mn5Sts;
    }

    public void setMn5Sts(Integer mn5Sts) {
        this.mn5Sts = mn5Sts;
    }

    public Integer getMn6Sts() {
        return mn6Sts;
    }

    public void setMn6Sts(Integer mn6Sts) {
        this.mn6Sts = mn6Sts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}