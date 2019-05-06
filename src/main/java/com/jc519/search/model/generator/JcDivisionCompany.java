package com.jc519.search.model.generator;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 
 * 实体类对应的数据表为：  jc_division_company
 * @author Jeff
 * @date 2018-01-17 13:50:31
 */
@ApiModel(value ="JcDivisionCompany")
public class JcDivisionCompany {
    @ApiModelProperty(value = "事业部公司关系表ID")
    private Integer id;

    @ApiModelProperty(value = "事业部ID")
    private Integer divisionId;

    @ApiModelProperty(value = "公司ID")
    private Integer companyId;

    @ApiModelProperty(value = "绑定状态(0-未绑定、1-绑定、2-申请）", dataType = "java.lang.Integer")
    private Byte bindStatus;

    @ApiModelProperty(value = "审核状态(2-未审核、1-通过)", dataType = "java.lang.Integer")
    private Byte auditStatus;

    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "申请用户ID")
    private Integer createUserId;

    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private Date auditTime;

    @ApiModelProperty(value = "审核用户ID")
    private Integer auditUserId;

    @ApiModelProperty(value = "是否删除0-是、1-否", dataType = "java.lang.Integer")
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Byte bindStatus) {
        this.bindStatus = bindStatus;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}