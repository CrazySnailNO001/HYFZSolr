package com.jc519.search.web.rest.search.result;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SearchMedicineGoodsResult {

    @ApiModelProperty(value = "商品id")
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String tradeName;

    @ApiModelProperty(value = "通用名称")
    private String genericName;

    @ApiModelProperty(value = "商品图片")
    private String imgUrl;

    @ApiModelProperty(value = "规格")
    private String specification;

    @ApiModelProperty(value = "生产企业")
    private String produceEnterprice;

    @ApiModelProperty(value = "批准文号")
    private String approvalNum;

    @ApiModelProperty(value = "供应商ID")
    private String companyId;

    @ApiModelProperty(value = "供应商名称")
    private String companyName;

    @ApiModelProperty(value = "剂型")
    private String dosageFormName;

    @ApiModelProperty(value = "整箱数量")
    private String boxNum;

    @ApiModelProperty(value = "单位")
    private String unitName;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "库存")
    private Integer stockNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(String approvalNum) {
        this.approvalNum = approvalNum;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDosageFormName() {
        return dosageFormName;
    }

    public void setDosageFormName(String dosageFormName) {
        this.dosageFormName = dosageFormName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(String boxNum) {
        this.boxNum = boxNum;
    }
}
