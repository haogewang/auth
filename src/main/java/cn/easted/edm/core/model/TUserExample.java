package cn.easted.edm.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Integer offset;

	protected Integer limit;

	public TUserExample() {
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
		this.offset = offset;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
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

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
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

		public Criteria andStatusEqualTo(Long value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Long value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Long value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Long value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Long value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Long value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Long> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Long> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Long value1, Long value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Long value1, Long value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createtime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createtime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Date value) {
			addCriterion("createtime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Date value) {
			addCriterion("createtime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Date value) {
			addCriterion("createtime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("createtime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Date value) {
			addCriterion("createtime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
			addCriterion("createtime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Date> values) {
			addCriterion("createtime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Date> values) {
			addCriterion("createtime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Date value1, Date value2) {
			addCriterion("createtime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
			addCriterion("createtime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andUsergroupsIsNull() {
			addCriterion("usergroups is null");
			return (Criteria) this;
		}

		public Criteria andUsergroupsIsNotNull() {
			addCriterion("usergroups is not null");
			return (Criteria) this;
		}

		public Criteria andUsergroupsEqualTo(String value) {
			addCriterion("usergroups =", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsNotEqualTo(String value) {
			addCriterion("usergroups <>", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsGreaterThan(String value) {
			addCriterion("usergroups >", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsGreaterThanOrEqualTo(String value) {
			addCriterion("usergroups >=", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsLessThan(String value) {
			addCriterion("usergroups <", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsLessThanOrEqualTo(String value) {
			addCriterion("usergroups <=", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsLike(String value) {
			addCriterion("usergroups like", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsNotLike(String value) {
			addCriterion("usergroups not like", value, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsIn(List<String> values) {
			addCriterion("usergroups in", values, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsNotIn(List<String> values) {
			addCriterion("usergroups not in", values, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsBetween(String value1, String value2) {
			addCriterion("usergroups between", value1, value2, "usergroups");
			return (Criteria) this;
		}

		public Criteria andUsergroupsNotBetween(String value1, String value2) {
			addCriterion("usergroups not between", value1, value2, "usergroups");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
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

		public Criteria andTypeEqualTo(Long value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Long value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Long value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Long value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Long value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Long value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Long> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Long> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Long value1, Long value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Long value1, Long value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andUserrolesIsNull() {
			addCriterion("userroles is null");
			return (Criteria) this;
		}

		public Criteria andUserrolesIsNotNull() {
			addCriterion("userroles is not null");
			return (Criteria) this;
		}

		public Criteria andUserrolesEqualTo(String value) {
			addCriterion("userroles =", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesNotEqualTo(String value) {
			addCriterion("userroles <>", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesGreaterThan(String value) {
			addCriterion("userroles >", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesGreaterThanOrEqualTo(String value) {
			addCriterion("userroles >=", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesLessThan(String value) {
			addCriterion("userroles <", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesLessThanOrEqualTo(String value) {
			addCriterion("userroles <=", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesLike(String value) {
			addCriterion("userroles like", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesNotLike(String value) {
			addCriterion("userroles not like", value, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesIn(List<String> values) {
			addCriterion("userroles in", values, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesNotIn(List<String> values) {
			addCriterion("userroles not in", values, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesBetween(String value1, String value2) {
			addCriterion("userroles between", value1, value2, "userroles");
			return (Criteria) this;
		}

		public Criteria andUserrolesNotBetween(String value1, String value2) {
			addCriterion("userroles not between", value1, value2, "userroles");
			return (Criteria) this;
		}

		public Criteria andUuidIsNull() {
			addCriterion("uuid is null");
			return (Criteria) this;
		}

		public Criteria andUuidIsNotNull() {
			addCriterion("uuid is not null");
			return (Criteria) this;
		}

		public Criteria andUuidEqualTo(String value) {
			addCriterion("uuid =", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotEqualTo(String value) {
			addCriterion("uuid <>", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidGreaterThan(String value) {
			addCriterion("uuid >", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidGreaterThanOrEqualTo(String value) {
			addCriterion("uuid >=", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLessThan(String value) {
			addCriterion("uuid <", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLessThanOrEqualTo(String value) {
			addCriterion("uuid <=", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidLike(String value) {
			addCriterion("uuid like", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotLike(String value) {
			addCriterion("uuid not like", value, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidIn(List<String> values) {
			addCriterion("uuid in", values, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotIn(List<String> values) {
			addCriterion("uuid not in", values, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidBetween(String value1, String value2) {
			addCriterion("uuid between", value1, value2, "uuid");
			return (Criteria) this;
		}

		public Criteria andUuidNotBetween(String value1, String value2) {
			addCriterion("uuid not between", value1, value2, "uuid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidIsNull() {
			addCriterion("domainentryid is null");
			return (Criteria) this;
		}

		public Criteria andDomainentryidIsNotNull() {
			addCriterion("domainentryid is not null");
			return (Criteria) this;
		}

		public Criteria andDomainentryidEqualTo(String value) {
			addCriterion("domainentryid =", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidNotEqualTo(String value) {
			addCriterion("domainentryid <>", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidGreaterThan(String value) {
			addCriterion("domainentryid >", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidGreaterThanOrEqualTo(String value) {
			addCriterion("domainentryid >=", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidLessThan(String value) {
			addCriterion("domainentryid <", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidLessThanOrEqualTo(String value) {
			addCriterion("domainentryid <=", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidLike(String value) {
			addCriterion("domainentryid like", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidNotLike(String value) {
			addCriterion("domainentryid not like", value, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidIn(List<String> values) {
			addCriterion("domainentryid in", values, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidNotIn(List<String> values) {
			addCriterion("domainentryid not in", values, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidBetween(String value1, String value2) {
			addCriterion("domainentryid between", value1, value2, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainentryidNotBetween(String value1, String value2) {
			addCriterion("domainentryid not between", value1, value2, "domainentryid");
			return (Criteria) this;
		}

		public Criteria andDomainIsNull() {
			addCriterion("domain is null");
			return (Criteria) this;
		}

		public Criteria andDomainIsNotNull() {
			addCriterion("domain is not null");
			return (Criteria) this;
		}

		public Criteria andDomainEqualTo(String value) {
			addCriterion("domain =", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotEqualTo(String value) {
			addCriterion("domain <>", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainGreaterThan(String value) {
			addCriterion("domain >", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainGreaterThanOrEqualTo(String value) {
			addCriterion("domain >=", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLessThan(String value) {
			addCriterion("domain <", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLessThanOrEqualTo(String value) {
			addCriterion("domain <=", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainLike(String value) {
			addCriterion("domain like", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotLike(String value) {
			addCriterion("domain not like", value, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainIn(List<String> values) {
			addCriterion("domain in", values, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotIn(List<String> values) {
			addCriterion("domain not in", values, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainBetween(String value1, String value2) {
			addCriterion("domain between", value1, value2, "domain");
			return (Criteria) this;
		}

		public Criteria andDomainNotBetween(String value1, String value2) {
			addCriterion("domain not between", value1, value2, "domain");
			return (Criteria) this;
		}

		public Criteria andLastloginIsNull() {
			addCriterion("lastlogin is null");
			return (Criteria) this;
		}

		public Criteria andLastloginIsNotNull() {
			addCriterion("lastlogin is not null");
			return (Criteria) this;
		}

		public Criteria andLastloginEqualTo(Date value) {
			addCriterion("lastlogin =", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginNotEqualTo(Date value) {
			addCriterion("lastlogin <>", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginGreaterThan(Date value) {
			addCriterion("lastlogin >", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginGreaterThanOrEqualTo(Date value) {
			addCriterion("lastlogin >=", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginLessThan(Date value) {
			addCriterion("lastlogin <", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginLessThanOrEqualTo(Date value) {
			addCriterion("lastlogin <=", value, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginIn(List<Date> values) {
			addCriterion("lastlogin in", values, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginNotIn(List<Date> values) {
			addCriterion("lastlogin not in", values, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginBetween(Date value1, Date value2) {
			addCriterion("lastlogin between", value1, value2, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andLastloginNotBetween(Date value1, Date value2) {
			addCriterion("lastlogin not between", value1, value2, "lastlogin");
			return (Criteria) this;
		}

		public Criteria andSessionstatusIsNull() {
			addCriterion("sessionstatus is null");
			return (Criteria) this;
		}

		public Criteria andSessionstatusIsNotNull() {
			addCriterion("sessionstatus is not null");
			return (Criteria) this;
		}

		public Criteria andSessionstatusEqualTo(String value) {
			addCriterion("sessionstatus =", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusNotEqualTo(String value) {
			addCriterion("sessionstatus <>", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusGreaterThan(String value) {
			addCriterion("sessionstatus >", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusGreaterThanOrEqualTo(String value) {
			addCriterion("sessionstatus >=", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusLessThan(String value) {
			addCriterion("sessionstatus <", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusLessThanOrEqualTo(String value) {
			addCriterion("sessionstatus <=", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusLike(String value) {
			addCriterion("sessionstatus like", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusNotLike(String value) {
			addCriterion("sessionstatus not like", value, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusIn(List<String> values) {
			addCriterion("sessionstatus in", values, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusNotIn(List<String> values) {
			addCriterion("sessionstatus not in", values, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusBetween(String value1, String value2) {
			addCriterion("sessionstatus between", value1, value2, "sessionstatus");
			return (Criteria) this;
		}

		public Criteria andSessionstatusNotBetween(String value1, String value2) {
			addCriterion("sessionstatus not between", value1, value2, "sessionstatus");
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

		public Criteria andVersionEqualTo(Long value) {
			addCriterion("version =", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotEqualTo(Long value) {
			addCriterion("version <>", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThan(Long value) {
			addCriterion("version >", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThanOrEqualTo(Long value) {
			addCriterion("version >=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThan(Long value) {
			addCriterion("version <", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThanOrEqualTo(Long value) {
			addCriterion("version <=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionIn(List<Long> values) {
			addCriterion("version in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotIn(List<Long> values) {
			addCriterion("version not in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionBetween(Long value1, Long value2) {
			addCriterion("version between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotBetween(Long value1, Long value2) {
			addCriterion("version not between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andEcenteridIsNull() {
			addCriterion("ecenterid is null");
			return (Criteria) this;
		}

		public Criteria andEcenteridIsNotNull() {
			addCriterion("ecenterid is not null");
			return (Criteria) this;
		}

		public Criteria andEcenteridEqualTo(String value) {
			addCriterion("ecenterid =", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridNotEqualTo(String value) {
			addCriterion("ecenterid <>", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridGreaterThan(String value) {
			addCriterion("ecenterid >", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridGreaterThanOrEqualTo(String value) {
			addCriterion("ecenterid >=", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridLessThan(String value) {
			addCriterion("ecenterid <", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridLessThanOrEqualTo(String value) {
			addCriterion("ecenterid <=", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridLike(String value) {
			addCriterion("ecenterid like", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridNotLike(String value) {
			addCriterion("ecenterid not like", value, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridIn(List<String> values) {
			addCriterion("ecenterid in", values, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridNotIn(List<String> values) {
			addCriterion("ecenterid not in", values, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridBetween(String value1, String value2) {
			addCriterion("ecenterid between", value1, value2, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andEcenteridNotBetween(String value1, String value2) {
			addCriterion("ecenterid not between", value1, value2, "ecenterid");
			return (Criteria) this;
		}

		public Criteria andReserveIsNull() {
			addCriterion("reserve is null");
			return (Criteria) this;
		}

		public Criteria andReserveIsNotNull() {
			addCriterion("reserve is not null");
			return (Criteria) this;
		}

		public Criteria andReserveEqualTo(String value) {
			addCriterion("reserve =", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveNotEqualTo(String value) {
			addCriterion("reserve <>", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveGreaterThan(String value) {
			addCriterion("reserve >", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveGreaterThanOrEqualTo(String value) {
			addCriterion("reserve >=", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveLessThan(String value) {
			addCriterion("reserve <", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveLessThanOrEqualTo(String value) {
			addCriterion("reserve <=", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveLike(String value) {
			addCriterion("reserve like", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveNotLike(String value) {
			addCriterion("reserve not like", value, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveIn(List<String> values) {
			addCriterion("reserve in", values, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveNotIn(List<String> values) {
			addCriterion("reserve not in", values, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveBetween(String value1, String value2) {
			addCriterion("reserve between", value1, value2, "reserve");
			return (Criteria) this;
		}

		public Criteria andReserveNotBetween(String value1, String value2) {
			addCriterion("reserve not between", value1, value2, "reserve");
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