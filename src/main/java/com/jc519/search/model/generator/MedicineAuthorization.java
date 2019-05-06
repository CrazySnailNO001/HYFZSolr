package com.jc519.search.model.generator;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 药品授权表
 * 实体类对应的数据表为：  jc_medicine_authorization
 * @author Jeff
 * @date 2018-01-16 11:38:31
 */
@ApiModel(value ="MedicineAuthorization")
public class MedicineAuthorization {
    @ApiModelProperty(value = "授权id")
    private Integer authId;

    @ApiModelProperty(value = "医药企业id")
    private Integer companyId;

    @ApiModelProperty(value = "渠道id")
    private Integer channelId;

    @ApiModelProperty(value = "被授权渠道id,终端授权为-1")
    private Integer controlChannelId;

    @ApiModelProperty(value = "控销医药公司id(被授权id)")
    private Integer auControlCompanyId;

    @ApiModelProperty(value = "药品产品id")
    private Integer medicineProductId;

    @ApiModelProperty(value = "事业部药品id")
    private Integer divisionMedicineId;

    @ApiModelProperty(value = "控销授权价格")
    private BigDecimal authorizationPrice;

    @ApiModelProperty(value = "状态，待上架-0，已上架-1，已下架-2", dataType = "java.lang.Integer")
    private Byte status;

    @ApiModelProperty(value = "是否删除，0-正常，1-删除", dataType = "java.lang.Integer")
    private Byte isDelete;

    @ApiModelProperty(value = "授权商品备注")
    private String authorizationRemark;

    @ApiModelProperty(value = "创建人id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public MedicineAuthorization(Integer authId, Integer companyId, Integer channelId, Integer controlChannelId, Integer auControlCompanyId, Integer medicineProductId, Integer divisionMedicineId, BigDecimal authorizationPrice, Byte status, Byte isDelete, String authorizationRemark, Integer createUserId, Date createTime) {
        this.authId = authId;
        this.companyId = companyId;
        this.channelId = channelId;
        this.controlChannelId = controlChannelId;
        this.auControlCompanyId = auControlCompanyId;
        this.medicineProductId = medicineProductId;
        this.divisionMedicineId = divisionMedicineId;
        this.authorizationPrice = authorizationPrice;
        this.status = status;
        this.isDelete = isDelete;
        this.authorizationRemark = authorizationRemark;
        this.createUserId = createUserId;
        this.createTime = createTime;
    }

    public MedicineAuthorization() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getControlChannelId() {
        return controlChannelId;
    }

    public void setControlChannelId(Integer controlChannelId) {
        this.controlChannelId = controlChannelId;
    }

    public Integer getAuControlCompanyId() {
        return auControlCompanyId;
    }

    public void setAuControlCompanyId(Integer auControlCompanyId) {
        this.auControlCompanyId = auControlCompanyId;
    }

    public Integer getMedicineProductId() {
        return medicineProductId;
    }

    public void setMedicineProductId(Integer medicineProductId) {
        this.medicineProductId = medicineProductId;
    }

    public Integer getDivisionMedicineId() {
        return divisionMedicineId;
    }

    public void setDivisionMedicineId(Integer divisionMedicineId) {
        this.divisionMedicineId = divisionMedicineId;
    }

    public BigDecimal getAuthorizationPrice() {
        return authorizationPrice;
    }

    public void setAuthorizationPrice(BigDecimal authorizationPrice) {
        this.authorizationPrice = authorizationPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getAuthorizationRemark() {
        return authorizationRemark;
    }

    public void setAuthorizationRemark(String authorizationRemark) {
        this.authorizationRemark = authorizationRemark;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}