package cn.easted.edm.core.model;

import java.util.Date;

public class TUser {
	private Long id;

	private String username;

	private String nickname;

	private String password;

	private Long status;

	private Date createtime;

	private String usergroups;

	private String email;

	private String phone;

	private Long type;

	private String userroles;

	private String uuid;

	private String domainentryid;

	private String domain;

	private Date lastlogin;

	private String sessionstatus;

	private Long version;

	private String ecenterid;

	private String reserve;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getUsergroups() {
		return usergroups;
	}

	public void setUsergroups(String usergroups) {
		this.usergroups = usergroups == null ? null : usergroups.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getUserroles() {
		return userroles;
	}

	public void setUserroles(String userroles) {
		this.userroles = userroles == null ? null : userroles.trim();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getDomainentryid() {
		return domainentryid;
	}

	public void setDomainentryid(String domainentryid) {
		this.domainentryid = domainentryid == null ? null : domainentryid.trim();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getSessionstatus() {
		return sessionstatus;
	}

	public void setSessionstatus(String sessionstatus) {
		this.sessionstatus = sessionstatus == null ? null : sessionstatus.trim();
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getEcenterid() {
		return ecenterid;
	}

	public void setEcenterid(String ecenterid) {
		this.ecenterid = ecenterid == null ? null : ecenterid.trim();
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve == null ? null : reserve.trim();
	}
}