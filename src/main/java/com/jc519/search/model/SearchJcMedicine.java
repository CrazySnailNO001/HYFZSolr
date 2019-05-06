package com.jc519.search.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * 搜索后,返回页面的集采目录查询结果(接收solr服务器数据)
 * @author Administrator
 *
 */
@SolrDocument(solrCoreName="gettingstarted")
public class SearchJcMedicine{

	@Id
	@Field
	private Integer id;
	
	@Field(value="img_url")
	private String imgUrl;		//药品图片
	
	@Field(value="generic_name")
	private String genericName;	//通用名
	
	@Field(value="trade_name")
	private String tradeName;	//商品名
	
	@Field
	private String specification;	//规格
	
	@Field(value="dosage_form_name")
	private String dosageFormName;	//剂型
	
	@Field(value="company_name")
	private String companyName;	//医药公司
	
	@Field(value="reimbursement_type")
	private String reimbursementType;	//报销类型(基药-0，医保药-1，非医保药-2)
	
	@Field(value="availability_price")
	private String availabilityPrice;	//供货价
	
	@Field(value="medicine_package")
	private String medicinePackage;	//整箱
	
	@Field(value="unit_name")
	private String unitName;	//单位

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getDosageFormName() {
		return dosageFormName;
	}
	public void setDosageFormName(String dosageFormName) {
		this.dosageFormName = dosageFormName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	public String getAvailabilityPrice() {
		return availabilityPrice;
	}
	public void setAvailabilityPrice(String availabilityPrice) {
		this.availabilityPrice = availabilityPrice;
	}
	public String getMedicinePackage() {
		return medicinePackage;
	}
	public void setMedicinePackage(String medicinePackage) {
		this.medicinePackage = medicinePackage;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
}
