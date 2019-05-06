package com.jc519.search.model.generator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineAuthorizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicineAuthorizationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIsNull() {
            addCriterion("division_id is null");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIsNotNull() {
            addCriterion("division_id is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionIdEqualTo(Integer value) {
            addCriterion("division_id =", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotEqualTo(Integer value) {
            addCriterion("division_id <>", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdGreaterThan(Integer value) {
            addCriterion("division_id >", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_id >=", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdLessThan(Integer value) {
            addCriterion("division_id <", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdLessThanOrEqualTo(Integer value) {
            addCriterion("division_id <=", value, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdIn(List<Integer> values) {
            addCriterion("division_id in", values, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotIn(List<Integer> values) {
            addCriterion("division_id not in", values, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdBetween(Integer value1, Integer value2) {
            addCriterion("division_id between", value1, value2, "divisionId");
            return (Criteria) this;
        }

        public Criteria andDivisionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("division_id not between", value1, value2, "divisionId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdIsNull() {
            addCriterion("control_division_id is null");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdIsNotNull() {
            addCriterion("control_division_id is not null");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdEqualTo(Integer value) {
            addCriterion("control_division_id =", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdNotEqualTo(Integer value) {
            addCriterion("control_division_id <>", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdGreaterThan(Integer value) {
            addCriterion("control_division_id >", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("control_division_id >=", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdLessThan(Integer value) {
            addCriterion("control_division_id <", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdLessThanOrEqualTo(Integer value) {
            addCriterion("control_division_id <=", value, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdIn(List<Integer> values) {
            addCriterion("control_division_id in", values, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdNotIn(List<Integer> values) {
            addCriterion("control_division_id not in", values, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdBetween(Integer value1, Integer value2) {
            addCriterion("control_division_id between", value1, value2, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlDivisionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("control_division_id not between", value1, value2, "controlDivisionId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdIsNull() {
            addCriterion("control_user_id is null");
            return (Criteria) this;
        }

        public Criteria andControlUserIdIsNotNull() {
            addCriterion("control_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andControlUserIdEqualTo(Integer value) {
            addCriterion("control_user_id =", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdNotEqualTo(Integer value) {
            addCriterion("control_user_id <>", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdGreaterThan(Integer value) {
            addCriterion("control_user_id >", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("control_user_id >=", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdLessThan(Integer value) {
            addCriterion("control_user_id <", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("control_user_id <=", value, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdIn(List<Integer> values) {
            addCriterion("control_user_id in", values, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdNotIn(List<Integer> values) {
            addCriterion("control_user_id not in", values, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdBetween(Integer value1, Integer value2) {
            addCriterion("control_user_id between", value1, value2, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("control_user_id not between", value1, value2, "controlUserId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdIsNull() {
            addCriterion("control_company_id is null");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdIsNotNull() {
            addCriterion("control_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdEqualTo(Integer value) {
            addCriterion("control_company_id =", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdNotEqualTo(Integer value) {
            addCriterion("control_company_id <>", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdGreaterThan(Integer value) {
            addCriterion("control_company_id >", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("control_company_id >=", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdLessThan(Integer value) {
            addCriterion("control_company_id <", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("control_company_id <=", value, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdIn(List<Integer> values) {
            addCriterion("control_company_id in", values, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdNotIn(List<Integer> values) {
            addCriterion("control_company_id not in", values, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("control_company_id between", value1, value2, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andControlCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("control_company_id not between", value1, value2, "controlCompanyId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdIsNull() {
            addCriterion("medicine_product_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdIsNotNull() {
            addCriterion("medicine_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdEqualTo(Integer value) {
            addCriterion("medicine_product_id =", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdNotEqualTo(Integer value) {
            addCriterion("medicine_product_id <>", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdGreaterThan(Integer value) {
            addCriterion("medicine_product_id >", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_product_id >=", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdLessThan(Integer value) {
            addCriterion("medicine_product_id <", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_product_id <=", value, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdIn(List<Integer> values) {
            addCriterion("medicine_product_id in", values, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdNotIn(List<Integer> values) {
            addCriterion("medicine_product_id not in", values, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdBetween(Integer value1, Integer value2) {
            addCriterion("medicine_product_id between", value1, value2, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andMedicineProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_product_id not between", value1, value2, "medicineProductId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdIsNull() {
            addCriterion("division_medicine_id is null");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdIsNotNull() {
            addCriterion("division_medicine_id is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdEqualTo(Integer value) {
            addCriterion("division_medicine_id =", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdNotEqualTo(Integer value) {
            addCriterion("division_medicine_id <>", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdGreaterThan(Integer value) {
            addCriterion("division_medicine_id >", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("division_medicine_id >=", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdLessThan(Integer value) {
            addCriterion("division_medicine_id <", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdLessThanOrEqualTo(Integer value) {
            addCriterion("division_medicine_id <=", value, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdIn(List<Integer> values) {
            addCriterion("division_medicine_id in", values, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdNotIn(List<Integer> values) {
            addCriterion("division_medicine_id not in", values, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdBetween(Integer value1, Integer value2) {
            addCriterion("division_medicine_id between", value1, value2, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andDivisionMedicineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("division_medicine_id not between", value1, value2, "divisionMedicineId");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceIsNull() {
            addCriterion("authorization_price is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceIsNotNull() {
            addCriterion("authorization_price is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceEqualTo(BigDecimal value) {
            addCriterion("authorization_price =", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceNotEqualTo(BigDecimal value) {
            addCriterion("authorization_price <>", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceGreaterThan(BigDecimal value) {
            addCriterion("authorization_price >", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("authorization_price >=", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceLessThan(BigDecimal value) {
            addCriterion("authorization_price <", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("authorization_price <=", value, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceIn(List<BigDecimal> values) {
            addCriterion("authorization_price in", values, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceNotIn(List<BigDecimal> values) {
            addCriterion("authorization_price not in", values, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("authorization_price between", value1, value2, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andAuthorizationPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("authorization_price not between", value1, value2, "authorizationPrice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdIsNull() {
            addCriterion("price_template_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdIsNotNull() {
            addCriterion("price_template_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdEqualTo(Integer value) {
            addCriterion("price_template_type_id =", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdNotEqualTo(Integer value) {
            addCriterion("price_template_type_id <>", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdGreaterThan(Integer value) {
            addCriterion("price_template_type_id >", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_template_type_id >=", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdLessThan(Integer value) {
            addCriterion("price_template_type_id <", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("price_template_type_id <=", value, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdIn(List<Integer> values) {
            addCriterion("price_template_type_id in", values, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdNotIn(List<Integer> values) {
            addCriterion("price_template_type_id not in", values, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("price_template_type_id between", value1, value2, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andPriceTemplateTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("price_template_type_id not between", value1, value2, "priceTemplateTypeId");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkIsNull() {
            addCriterion("authorization_remark is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkIsNotNull() {
            addCriterion("authorization_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkEqualTo(String value) {
            addCriterion("authorization_remark =", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkNotEqualTo(String value) {
            addCriterion("authorization_remark <>", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkGreaterThan(String value) {
            addCriterion("authorization_remark >", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("authorization_remark >=", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkLessThan(String value) {
            addCriterion("authorization_remark <", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkLessThanOrEqualTo(String value) {
            addCriterion("authorization_remark <=", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkLike(String value) {
            addCriterion("authorization_remark like", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkNotLike(String value) {
            addCriterion("authorization_remark not like", value, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkIn(List<String> values) {
            addCriterion("authorization_remark in", values, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkNotIn(List<String> values) {
            addCriterion("authorization_remark not in", values, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkBetween(String value1, String value2) {
            addCriterion("authorization_remark between", value1, value2, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andAuthorizationRemarkNotBetween(String value1, String value2) {
            addCriterion("authorization_remark not between", value1, value2, "authorizationRemark");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}