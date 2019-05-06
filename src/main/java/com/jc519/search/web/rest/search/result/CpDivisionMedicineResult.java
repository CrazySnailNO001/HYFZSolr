package com.jc519.search.web.rest.search.result;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class CpDivisionMedicineResult {

    @ApiModelProperty(value = "授权关系id")
    private Integer id;

    @ApiModelProperty(value = "授权医药公司id")
    private Integer companyId;

    @ApiModelProperty(value = "授权渠道id")
    private Integer channelId;

    @ApiModelProperty(value = "授权渠道id")
    private Integer controlChannelId;

    @ApiModelProperty(value = "授权渠道id")
    private Integer controlCompanyId;

    @ApiModelProperty(value = "事业部药品id")
    private Integer divisionMedicineId;

    @ApiModelProperty(value = "药品产品id")
    private Integer medicineProductId;

    @ApiModelProperty(value = "所属栏目，1-集采，2-控销", dataType = "java.lang.Integer")
    private Byte belongColumn;

    @ApiModelProperty(value = "药品名称")
    private String tradeName;

    @ApiModelProperty(value = "通用名称")
    private String genericName;

    @ApiModelProperty(value = "规格")
    private String specification;

    @ApiModelProperty(value = "生产企业")
    private String produceEnterprice;

    @ApiModelProperty(value = "整箱数量")
    private Integer boxNum;

    @ApiModelProperty(value = "单位id")
    private Integer unitId;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "是否启用，0启用，1停用", dataType = "java.lang.Integer")
    private Byte isUse;

    @ApiModelProperty(value = "控销授权价格")
    private BigDecimal authorizationPrice;

    @ApiModelProperty(value = "状态，0-待上架，1-已上架，2-已下架", dataType = "java.lang.Integer")
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public Byte getBelongColumn() {
        return belongColumn;
    }

    public void setBelongColumn(Byte belongColumn) {
        this.belongColumn = belongColumn;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProduceEnterprice() {
        return produceEnterprice;
    }

    public void setProduceEnterprice(String produceEnterprice) {
        this.produceEnterprice = produceEnterprice;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getControlChannelId() {
        return controlChannelId;
    }

    public void setControlChannelId(Integer controlChannelId) {
        this.controlChannelId = controlChannelId;
    }

    public Integer getControlCompanyId() {
        return controlCompanyId;
    }

    public void setControlCompanyId(Integer controlCompanyId) {
        this.controlCompanyId = controlCompanyId;
    }
}
