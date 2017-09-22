package cn.easted.edm.core.model;

public class TRole {
	private Long id;

	private String roleName;

	private String roleSign;

	private String discription;

	private String rolepermissions;

	private Long version;

	private String reserve;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign == null ? null : roleSign.trim();
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription == null ? null : discription.trim();
	}

	public String getRolepermissions() {
		return rolepermissions;
	}

	public void setRolepermissions(String rolepermissions) {
		this.rolepermissions = rolepermissions == null ? null : rolepermissions.trim();
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve == null ? null : reserve.trim();
	}
}