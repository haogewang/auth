package cn.easted.edm.core.model;

import java.util.ArrayList;
import java.util.List;

public class TPermissionExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TPermissionExample() {
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

		public Criteria andPermissionNameIsNull() {
			addCriterion("permission_name is null");
			return (Criteria) this;
		}

		public Criteria andPermissionNameIsNotNull() {
			addCriterion("permission_name is not null");
			return (Criteria) this;
		}

		public Criteria andPermissionNameEqualTo(String value) {
			addCriterion("permission_name =", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameNotEqualTo(String value) {
			addCriterion("permission_name <>", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameGreaterThan(String value) {
			addCriterion("permission_name >", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
			addCriterion("permission_name >=", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameLessThan(String value) {
			addCriterion("permission_name <", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameLessThanOrEqualTo(String value) {
			addCriterion("permission_name <=", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameLike(String value) {
			addCriterion("permission_name like", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameNotLike(String value) {
			addCriterion("permission_name not like", value, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameIn(List<String> values) {
			addCriterion("permission_name in", values, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameNotIn(List<String> values) {
			addCriterion("permission_name not in", values, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameBetween(String value1, String value2) {
			addCriterion("permission_name between", value1, value2, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionNameNotBetween(String value1, String value2) {
			addCriterion("permission_name not between", value1, value2, "permissionName");
			return (Criteria) this;
		}

		public Criteria andPermissionSignIsNull() {
			addCriterion("permission_sign is null");
			return (Criteria) this;
		}

		public Criteria andPermissionSignIsNotNull() {
			addCriterion("permission_sign is not null");
			return (Criteria) this;
		}

		public Criteria andPermissionSignEqualTo(String value) {
			addCriterion("permission_sign =", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignNotEqualTo(String value) {
			addCriterion("permission_sign <>", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignGreaterThan(String value) {
			addCriterion("permission_sign >", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignGreaterThanOrEqualTo(String value) {
			addCriterion("permission_sign >=", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignLessThan(String value) {
			addCriterion("permission_sign <", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignLessThanOrEqualTo(String value) {
			addCriterion("permission_sign <=", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignLike(String value) {
			addCriterion("permission_sign like", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignNotLike(String value) {
			addCriterion("permission_sign not like", value, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignIn(List<String> values) {
			addCriterion("permission_sign in", values, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignNotIn(List<String> values) {
			addCriterion("permission_sign not in", values, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignBetween(String value1, String value2) {
			addCriterion("permission_sign between", value1, value2, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andPermissionSignNotBetween(String value1, String value2) {
			addCriterion("permission_sign not between", value1, value2, "permissionSign");
			return (Criteria) this;
		}

		public Criteria andDiscriptionIsNull() {
			addCriterion("discription is null");
			return (Criteria) this;
		}

		public Criteria andDiscriptionIsNotNull() {
			addCriterion("discription is not null");
			return (Criteria) this;
		}

		public Criteria andDiscriptionEqualTo(String value) {
			addCriterion("discription =", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionNotEqualTo(String value) {
			addCriterion("discription <>", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionGreaterThan(String value) {
			addCriterion("discription >", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionGreaterThanOrEqualTo(String value) {
			addCriterion("discription >=", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionLessThan(String value) {
			addCriterion("discription <", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionLessThanOrEqualTo(String value) {
			addCriterion("discription <=", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionLike(String value) {
			addCriterion("discription like", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionNotLike(String value) {
			addCriterion("discription not like", value, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionIn(List<String> values) {
			addCriterion("discription in", values, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionNotIn(List<String> values) {
			addCriterion("discription not in", values, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionBetween(String value1, String value2) {
			addCriterion("discription between", value1, value2, "discription");
			return (Criteria) this;
		}

		public Criteria andDiscriptionNotBetween(String value1, String value2) {
			addCriterion("discription not between", value1, value2, "discription");
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