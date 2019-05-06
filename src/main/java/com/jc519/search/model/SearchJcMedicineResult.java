package com.jc519.search.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.math.BigDecimal;

/**
 * 导入数据时，与数据库表字段对应的model
 * @author Administrator
 *
 */
@SolrDocument(solrCoreName="gettingstarted")
public class SearchJcMedicineResult{

	@Id
	@Field
	private Integer id;

	@Field(value="medicine_product_id") // 产品ID
	private Integer medicineProductId;

	@Field(value="channel_id") // 授权渠道id
	private Integer channelId;
	
	@Field(value="generic_name")
	private String genericName;	//通用名
	
	@Field(value="trade_name")
	private String tradeName;	//商品名

	@Field(value="img_url")
	private String imgUrl;		//药品图片

	@Field
	private String specification;	//规格

	@Field(value="cate_id")
	private Integer categoryId;  //一级分类ID

	@Field(value="cate_second_id")
	private Integer cateSecondId;  //二级分类ID

    @Field(value="cate_third_id")
	private Integer cateThirdId;  //三级分类ID

	@Field(value="generic_cate_id")
	private Integer genericCateId;  //通用一级分类

    @Field(value="generic_cate_second_id")
	private Integer genericCateSecondId;  //通用二级分类

	@Field(value="dosage_form_id")
	private Integer dosageFormId; //剂型ID

	@Field(value="dosage_form_name")
	private String dosageFormName;	//剂型名称
	
	@Field(value="reimbursement_type")
	private Byte reimbursementType;	//医保类型，非医保-1，医保甲类-2，医保乙类-3

	@Field(value="basic_or_common")
	private Byte basicOrCommon;	//基药/普药，基药-1，普药-2

	@Field(value="produce_enterprice")
	private String produceEnterprice; // 生产企业

	@Field(value="approval_num")
	private String approvalNum; // 批准文号

	@Field(value="box_num")
	private String boxNum;	// 整箱数量

	@Field(value="unit_id")
	private String unitId;	//药品单位ID

	@Field(value="unit_name")
	private String unitName;	//药品单位名称

	@Field(value="company_id")
	private Integer companyId;	//医药公司Id

	@Field(value="company_name")
	private String companyName;	//医药公司名称
	
	@Field(value="suggested_price")
	private BigDecimal suggestedPrice;	//建议零售价

	@Field(value="availability_price")
	private BigDecimal availabilityPrice;	//供货价

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

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicineProductId() {
		return medicineProductId;
	}

	public void setMedicineProductId(Integer medicineProductId) {
		this.medicineProductId = medicineProductId;
	}

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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getDosageFormId() {
		return dosageFormId;
	}

	public void setDosageFormId(Integer dosageFormId) {
		this.dosageFormId = dosageFormId;
	}

	public String getDosageFormName() {
		return dosageFormName;
	}

	public void setDosageFormName(String dosageFormName) {
		this.dosageFormName = dosageFormName;
	}

	public Byte getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(Byte reimbursementType) {
		this.reimbursementType = reimbursementType;
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

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(BigDecimal suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public BigDecimal getAvailabilityPrice() {
		return availabilityPrice;
	}

	public void setAvailabilityPrice(BigDecimal availabilityPrice) {
		this.availabilityPrice = availabilityPrice;
	}

    public Byte getBasicOrCommon() {
        return basicOrCommon;
    }

    public void setBasicOrCommon(Byte basicOrCommon) {
        this.basicOrCommon = basicOrCommon;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(String boxNum) {
        this.boxNum = boxNum;
    }
}
