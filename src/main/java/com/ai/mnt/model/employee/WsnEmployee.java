package com.ai.mnt.model.employee;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Title: WsnEmployee 
 * @Description: WsnEmployee Model
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */
public class WsnEmployee implements Serializable{

    private static final long serialVersionUID = 1L;

    /**编号*/
    private Integer personId;

    /**员工姓名*/
    private String employeeName;

    /**员工年龄*/
    private Integer employeeAge;

    /**出生日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    /**员工工号*/
    private String employeeNumber;

    /**员工部门*/
    private String employeeDept;

    /**员工性别，0男，1女*/
    private String employeeGender;

    /**身份证号*/
    private String idcard;

    /**电话号码*/
    private String phoneNumber;

    /**参加工作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstWorkdate;

    /**持证种类*/
    private String certificateCategory;

    /**员工状态，1在职，0离职*/
    private String employeeStatus;

    /**备注*/
    private String remark;

    /**删除标识，1删除，0未删除*/
    private String deleteFlag;

    /**创建人*/
    private String creator;

    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**修改人*/
    private String modifier;

    /**修改时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getFirstWorkdate() {
        return firstWorkdate;
    }

    public void setFirstWorkdate(Date firstWorkdate) {
        this.firstWorkdate = firstWorkdate;
    }

    public String getCertificateCategory() {
        return certificateCategory;
    }

    public void setCertificateCategory(String certificateCategory) {
        this.certificateCategory = certificateCategory;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


}