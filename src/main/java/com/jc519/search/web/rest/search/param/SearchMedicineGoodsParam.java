package com.jc519.search.web.rest.search.param;

import io.swagger.annotations.ApiModelProperty;

public class SearchMedicineGoodsParam {
    public SearchMedicineGoodsParam() {

    }

    @ApiModelProperty(value="关键词")
    private String keyword;

    @ApiModelProperty(value="页码")
    private int pageNum=1;

    @ApiModelProperty(value="页面大小")
    private int pageSize=20;

    @ApiModelProperty(value="一级分类ID")
    private Integer categoryId;

    @ApiModelProperty(value="二级分类ID")
    private Integer cateSecondId;

    @ApiModelProperty(value="三级分类ID")
    private Integer cateThirdId;

    @ApiModelProperty(value="通用一级分类 APP不传!!!")
    private Integer genericCateId;

    @ApiModelProperty(value="通用二级分类 APP不传!!!")
    private Integer genericCateSecondId;

    @ApiModelProperty(value="剂型ID")
    private Integer dosageFormId;

    @ApiModelProperty(value="医保类型，非医保-1，医保甲类-2，医保乙类-3")
    private Integer reimbursementType;

    @ApiModelProperty(value="基药/普药，基药-1，普药-2")
    private Integer basicOrCommon;

    @ApiModelProperty(value="是否控销 不传:控销 1-集採 2-控销")
    private Integer isControl;

    @ApiModelProperty(value="1-PC端 2-APP端")
    private Integer type;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCateSecondId() {
        return cateSecondId;
    }

    public void setCateSecondId(Integer cateSecondId) {
        this.cateSecondId = cateSecondId;
    }

    public Integer getCateThirdId() {
        return cateThirdId;
    }

    public void setCateThirdId(Integer cateThirdId) {
        this.cateThirdId = cateThirdId;
    }

    public Integer getGenericCateId() {
        return genericCateId;
    }

    public void setGenericCateId(Integer genericCateId) {
        this.genericCateId = genericCateId;
    }

    public Integer getGenericCateSecondId() {
        return genericCateSecondId;
    }

    public void setGenericCateSecondId(Integer genericCateSecondId) {
        this.genericCateSecondId = genericCateSecondId;
    }

    public Integer getDosageFormId() {
        return dosageFormId;
    }

    public void setDosageFormId(Integer dosageFormId) {
        this.dosageFormId = dosageFormId;
    }

    public Integer getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(Integer reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    public Integer getBasicOrCommon() {
        return basicOrCommon;
    }

    public void setBasicOrCommon(Integer basicOrCommon) {
        this.basicOrCommon = basicOrCommon;
    }

    public Integer getIsControl() {
        return isControl;
    }

    public void setIsControl(Integer isControl) {
        this.isControl = isControl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}