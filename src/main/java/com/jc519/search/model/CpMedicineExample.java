package com.jc519.search.model;

import java.util.ArrayList;
import java.util.List;

public class CpMedicineExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpMedicineExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdIsNull() {
            addCriterion("authorization_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdIsNotNull() {
            addCriterion("authorization_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdEqualTo(Integer value) {
            addCriterion("authorization_id =", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andControlChannelIdEqualTo(Integer value) {
            addCriterion("control_channel_id =", value, "controlChannelId");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdNotEqualTo(Integer value) {
            addCriterion("authorization_id <>", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdGreaterThan(Integer value) {
            addCriterion("authorization_id >", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorization_id >=", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdLessThan(Integer value) {
            addCriterion("authorization_id <", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdLessThanOrEqualTo(Integer value) {
            addCriterion("authorization_id <=", value, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdIn(List<Integer> values) {
            addCriterion("authorization_id in", values, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdNotIn(List<Integer> values) {
            addCriterion("authorization_id not in", values, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdBetween(Integer value1, Integer value2) {
            addCriterion("authorization_id between", value1, value2, "authorization_id");
            return (Criteria) this;
        }

        public Criteria andAuthorizationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("authorization_id not between", value1, value2, "authorization_id");
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


        public Criteria andBelongColumnIsNull() {
            addCriterion("belong_column is null");
            return (Criteria) this;
        }

        public Criteria andBelongColumnIsNotNull() {
            addCriterion("belong_column is not null");
            return (Criteria) this;
        }

        public Criteria andBelongColumnEqualTo(Byte value) {
            addCriterion("belong_column =", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnNotEqualTo(Byte value) {
            addCriterion("belong_column <>", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnGreaterThan(Byte value) {
            addCriterion("belong_column >", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnGreaterThanOrEqualTo(Byte value) {
            addCriterion("belong_column >=", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnLessThan(Byte value) {
            addCriterion("belong_column <", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnLessThanOrEqualTo(Byte value) {
            addCriterion("belong_column <=", value, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnIn(List<Byte> values) {
            addCriterion("belong_column in", values, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnNotIn(List<Byte> values) {
            addCriterion("belong_column not in", values, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnBetween(Byte value1, Byte value2) {
            addCriterion("belong_column between", value1, value2, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andBelongColumnNotBetween(Byte value1, Byte value2) {
            addCriterion("belong_column not between", value1, value2, "belongColumn");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNull() {
            addCriterion("trade_name is null");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNotNull() {
            addCriterion("trade_name is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNameEqualTo(String value) {
            addCriterion("trade_name =", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotEqualTo(String value) {
            addCriterion("trade_name <>", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThan(String value) {
            addCriterion("trade_name >", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trade_name >=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThan(String value) {
            addCriterion("trade_name <", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThanOrEqualTo(String value) {
            addCriterion("trade_name <=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLike(String value) {
            addCriterion("trade_name like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotLike(String value) {
            addCriterion("trade_name not like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameIn(List<String> values) {
            addCriterion("trade_name in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotIn(List<String> values) {
            addCriterion("trade_name not in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameBetween(String value1, String value2) {
            addCriterion("trade_name between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotBetween(String value1, String value2) {
            addCriterion("trade_name not between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andGenericNameIsNull() {
            addCriterion("generic_name is null");
            return (Criteria) this;
        }

        public Criteria andGenericNameIsNotNull() {
            addCriterion("generic_name is not null");
            return (Criteria) this;
        }

        public Criteria andGenericNameEqualTo(String value) {
            addCriterion("generic_name =", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotEqualTo(String value) {
            addCriterion("generic_name <>", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameGreaterThan(String value) {
            addCriterion("generic_name >", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameGreaterThanOrEqualTo(String value) {
            addCriterion("generic_name >=", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLessThan(String value) {
            addCriterion("generic_name <", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLessThanOrEqualTo(String value) {
            addCriterion("generic_name <=", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameLike(String value) {
            addCriterion("generic_name like", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotLike(String value) {
            addCriterion("generic_name not like", value, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameIn(List<String> values) {
            addCriterion("generic_name in", values, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotIn(List<String> values) {
            addCriterion("generic_name not in", values, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameBetween(String value1, String value2) {
            addCriterion("generic_name between", value1, value2, "genericName");
            return (Criteria) this;
        }

        public Criteria andGenericNameNotBetween(String value1, String value2) {
            addCriterion("generic_name not between", value1, value2, "genericName");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceIsNull() {
            addCriterion("produce_enterprice is null");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceIsNotNull() {
            addCriterion("produce_enterprice is not null");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceEqualTo(String value) {
            addCriterion("produce_enterprice =", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceNotEqualTo(String value) {
            addCriterion("produce_enterprice <>", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceGreaterThan(String value) {
            addCriterion("produce_enterprice >", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceGreaterThanOrEqualTo(String value) {
            addCriterion("produce_enterprice >=", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceLessThan(String value) {
            addCriterion("produce_enterprice <", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceLessThanOrEqualTo(String value) {
            addCriterion("produce_enterprice <=", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceLike(String value) {
            addCriterion("produce_enterprice like", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceNotLike(String value) {
            addCriterion("produce_enterprice not like", value, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceIn(List<String> values) {
            addCriterion("produce_enterprice in", values, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceNotIn(List<String> values) {
            addCriterion("produce_enterprice not in", values, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceBetween(String value1, String value2) {
            addCriterion("produce_enterprice between", value1, value2, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andProduceEnterpriceNotBetween(String value1, String value2) {
            addCriterion("produce_enterprice not between", value1, value2, "produceEnterprice");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Byte value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Byte value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Byte value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Byte value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Byte value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Byte> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Byte> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Byte value1, Byte value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Byte value1, Byte value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(Byte value) {
            addCriterion("apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(Byte value) {
            addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(Byte value) {
            addCriterion("apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(Byte value) {
            addCriterion("apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<Byte> values) {
            addCriterion("apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<Byte> values) {
            addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(Byte value1, Byte value2) {
            addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("apply_status not between", value1, value2, "applyStatus");
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
