package cn.easted.edm.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAuthmanagementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer limit;

    public TAuthmanagementExample() {
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

    public void setOffset(Integer offset) {
        this.offset=offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setLimit(Integer limit) {
        this.limit=limit;
    }

    public Integer getLimit() {
        return limit;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andSerinumberIsNull() {
            addCriterion("serinumber is null");
            return (Criteria) this;
        }

        public Criteria andSerinumberIsNotNull() {
            addCriterion("serinumber is not null");
            return (Criteria) this;
        }

        public Criteria andSerinumberEqualTo(String value) {
            addCriterion("serinumber =", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberNotEqualTo(String value) {
            addCriterion("serinumber <>", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberGreaterThan(String value) {
            addCriterion("serinumber >", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberGreaterThanOrEqualTo(String value) {
            addCriterion("serinumber >=", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberLessThan(String value) {
            addCriterion("serinumber <", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberLessThanOrEqualTo(String value) {
            addCriterion("serinumber <=", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberLike(String value) {
            addCriterion("serinumber like", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberNotLike(String value) {
            addCriterion("serinumber not like", value, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberIn(List<String> values) {
            addCriterion("serinumber in", values, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberNotIn(List<String> values) {
            addCriterion("serinumber not in", values, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberBetween(String value1, String value2) {
            addCriterion("serinumber between", value1, value2, "serinumber");
            return (Criteria) this;
        }

        public Criteria andSerinumberNotBetween(String value1, String value2) {
            addCriterion("serinumber not between", value1, value2, "serinumber");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeIsNull() {
            addCriterion("authorizationcode is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeIsNotNull() {
            addCriterion("authorizationcode is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeEqualTo(String value) {
            addCriterion("authorizationcode =", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeNotEqualTo(String value) {
            addCriterion("authorizationcode <>", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeGreaterThan(String value) {
            addCriterion("authorizationcode >", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("authorizationcode >=", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeLessThan(String value) {
            addCriterion("authorizationcode <", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeLessThanOrEqualTo(String value) {
            addCriterion("authorizationcode <=", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeLike(String value) {
            addCriterion("authorizationcode like", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeNotLike(String value) {
            addCriterion("authorizationcode not like", value, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeIn(List<String> values) {
            addCriterion("authorizationcode in", values, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeNotIn(List<String> values) {
            addCriterion("authorizationcode not in", values, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeBetween(String value1, String value2) {
            addCriterion("authorizationcode between", value1, value2, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andAuthorizationcodeNotBetween(String value1, String value2) {
            addCriterion("authorizationcode not between", value1, value2, "authorizationcode");
            return (Criteria) this;
        }

        public Criteria andServernumberIsNull() {
            addCriterion("servernumber is null");
            return (Criteria) this;
        }

        public Criteria andServernumberIsNotNull() {
            addCriterion("servernumber is not null");
            return (Criteria) this;
        }

        public Criteria andServernumberEqualTo(String value) {
            addCriterion("servernumber =", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotEqualTo(String value) {
            addCriterion("servernumber <>", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberGreaterThan(String value) {
            addCriterion("servernumber >", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberGreaterThanOrEqualTo(String value) {
            addCriterion("servernumber >=", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberLessThan(String value) {
            addCriterion("servernumber <", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberLessThanOrEqualTo(String value) {
            addCriterion("servernumber <=", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberLike(String value) {
            addCriterion("servernumber like", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotLike(String value) {
            addCriterion("servernumber not like", value, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberIn(List<String> values) {
            addCriterion("servernumber in", values, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotIn(List<String> values) {
            addCriterion("servernumber not in", values, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberBetween(String value1, String value2) {
            addCriterion("servernumber between", value1, value2, "servernumber");
            return (Criteria) this;
        }

        public Criteria andServernumberNotBetween(String value1, String value2) {
            addCriterion("servernumber not between", value1, value2, "servernumber");
            return (Criteria) this;
        }

        public Criteria andAclientIsNull() {
            addCriterion("aclient is null");
            return (Criteria) this;
        }

        public Criteria andAclientIsNotNull() {
            addCriterion("aclient is not null");
            return (Criteria) this;
        }

        public Criteria andAclientEqualTo(String value) {
            addCriterion("aclient =", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientNotEqualTo(String value) {
            addCriterion("aclient <>", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientGreaterThan(String value) {
            addCriterion("aclient >", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientGreaterThanOrEqualTo(String value) {
            addCriterion("aclient >=", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientLessThan(String value) {
            addCriterion("aclient <", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientLessThanOrEqualTo(String value) {
            addCriterion("aclient <=", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientLike(String value) {
            addCriterion("aclient like", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientNotLike(String value) {
            addCriterion("aclient not like", value, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientIn(List<String> values) {
            addCriterion("aclient in", values, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientNotIn(List<String> values) {
            addCriterion("aclient not in", values, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientBetween(String value1, String value2) {
            addCriterion("aclient between", value1, value2, "aclient");
            return (Criteria) this;
        }

        public Criteria andAclientNotBetween(String value1, String value2) {
            addCriterion("aclient not between", value1, value2, "aclient");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeIsNull() {
            addCriterion("bclient_machinecode is null");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeIsNotNull() {
            addCriterion("bclient_machinecode is not null");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeEqualTo(String value) {
            addCriterion("bclient_machinecode =", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeNotEqualTo(String value) {
            addCriterion("bclient_machinecode <>", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeGreaterThan(String value) {
            addCriterion("bclient_machinecode >", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeGreaterThanOrEqualTo(String value) {
            addCriterion("bclient_machinecode >=", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeLessThan(String value) {
            addCriterion("bclient_machinecode <", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeLessThanOrEqualTo(String value) {
            addCriterion("bclient_machinecode <=", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeLike(String value) {
            addCriterion("bclient_machinecode like", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeNotLike(String value) {
            addCriterion("bclient_machinecode not like", value, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeIn(List<String> values) {
            addCriterion("bclient_machinecode in", values, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeNotIn(List<String> values) {
            addCriterion("bclient_machinecode not in", values, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeBetween(String value1, String value2) {
            addCriterion("bclient_machinecode between", value1, value2, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBclientMachinecodeNotBetween(String value1, String value2) {
            addCriterion("bclient_machinecode not between", value1, value2, "bclientMachinecode");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberIsNull() {
            addCriterion("bauth_serilizenumber is null");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberIsNotNull() {
            addCriterion("bauth_serilizenumber is not null");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberEqualTo(String value) {
            addCriterion("bauth_serilizenumber =", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberNotEqualTo(String value) {
            addCriterion("bauth_serilizenumber <>", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberGreaterThan(String value) {
            addCriterion("bauth_serilizenumber >", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberGreaterThanOrEqualTo(String value) {
            addCriterion("bauth_serilizenumber >=", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberLessThan(String value) {
            addCriterion("bauth_serilizenumber <", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberLessThanOrEqualTo(String value) {
            addCriterion("bauth_serilizenumber <=", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberLike(String value) {
            addCriterion("bauth_serilizenumber like", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberNotLike(String value) {
            addCriterion("bauth_serilizenumber not like", value, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberIn(List<String> values) {
            addCriterion("bauth_serilizenumber in", values, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberNotIn(List<String> values) {
            addCriterion("bauth_serilizenumber not in", values, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberBetween(String value1, String value2) {
            addCriterion("bauth_serilizenumber between", value1, value2, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andBauthSerilizenumberNotBetween(String value1, String value2) {
            addCriterion("bauth_serilizenumber not between", value1, value2, "bauthSerilizenumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberIsNull() {
            addCriterion("contractnumber is null");
            return (Criteria) this;
        }

        public Criteria andContractnumberIsNotNull() {
            addCriterion("contractnumber is not null");
            return (Criteria) this;
        }

        public Criteria andContractnumberEqualTo(String value) {
            addCriterion("contractnumber =", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberNotEqualTo(String value) {
            addCriterion("contractnumber <>", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberGreaterThan(String value) {
            addCriterion("contractnumber >", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberGreaterThanOrEqualTo(String value) {
            addCriterion("contractnumber >=", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberLessThan(String value) {
            addCriterion("contractnumber <", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberLessThanOrEqualTo(String value) {
            addCriterion("contractnumber <=", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberLike(String value) {
            addCriterion("contractnumber like", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberNotLike(String value) {
            addCriterion("contractnumber not like", value, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberIn(List<String> values) {
            addCriterion("contractnumber in", values, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberNotIn(List<String> values) {
            addCriterion("contractnumber not in", values, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberBetween(String value1, String value2) {
            addCriterion("contractnumber between", value1, value2, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andContractnumberNotBetween(String value1, String value2) {
            addCriterion("contractnumber not between", value1, value2, "contractnumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberIsNull() {
            addCriterion("supervene_number is null");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberIsNotNull() {
            addCriterion("supervene_number is not null");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberEqualTo(String value) {
            addCriterion("supervene_number =", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberNotEqualTo(String value) {
            addCriterion("supervene_number <>", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberGreaterThan(String value) {
            addCriterion("supervene_number >", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("supervene_number >=", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberLessThan(String value) {
            addCriterion("supervene_number <", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberLessThanOrEqualTo(String value) {
            addCriterion("supervene_number <=", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberLike(String value) {
            addCriterion("supervene_number like", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberNotLike(String value) {
            addCriterion("supervene_number not like", value, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberIn(List<String> values) {
            addCriterion("supervene_number in", values, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberNotIn(List<String> values) {
            addCriterion("supervene_number not in", values, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberBetween(String value1, String value2) {
            addCriterion("supervene_number between", value1, value2, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andSuperveneNumberNotBetween(String value1, String value2) {
            addCriterion("supervene_number not between", value1, value2, "superveneNumber");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutIsNull() {
            addCriterion("auth_timeout is null");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutIsNotNull() {
            addCriterion("auth_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutEqualTo(String value) {
            addCriterion("auth_timeout =", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutNotEqualTo(String value) {
            addCriterion("auth_timeout <>", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutGreaterThan(String value) {
            addCriterion("auth_timeout >", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutGreaterThanOrEqualTo(String value) {
            addCriterion("auth_timeout >=", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutLessThan(String value) {
            addCriterion("auth_timeout <", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutLessThanOrEqualTo(String value) {
            addCriterion("auth_timeout <=", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutLike(String value) {
            addCriterion("auth_timeout like", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutNotLike(String value) {
            addCriterion("auth_timeout not like", value, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutIn(List<String> values) {
            addCriterion("auth_timeout in", values, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutNotIn(List<String> values) {
            addCriterion("auth_timeout not in", values, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutBetween(String value1, String value2) {
            addCriterion("auth_timeout between", value1, value2, "authTimeout");
            return (Criteria) this;
        }

        public Criteria andAuthTimeoutNotBetween(String value1, String value2) {
            addCriterion("auth_timeout not between", value1, value2, "authTimeout");
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