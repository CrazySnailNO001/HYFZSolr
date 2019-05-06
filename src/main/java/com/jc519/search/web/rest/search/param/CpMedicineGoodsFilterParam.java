package com.jc519.search.web.rest.search.param;

public class CpMedicineGoodsFilterParam {

    private String genericName;

    private String tradeName;

    private String produceEnterprice;

    private Byte isUse;

    private Byte status;

    private String companyName;

    private Integer companyId;

    private String keyWord;

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getProduceEnterprice() {
        return produceEnterprice;
    }

    public void setProduceEnterprice(String produceEnterprice) {
        this.produceEnterprice = produceEnterprice;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
