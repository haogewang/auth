package cn.easted.edm.core.generic.enums;

/**
 * 用户启用、禁用状态:<br>
 * DISABLE：0-禁用<br>
 * ENABLE：1-启用
 * 
 * @author lei
 *
 */
public enum UserStatus {

	DISABLE(0, "禁用"), ENABLE(1, "启用");

	private int value;
	private String info;

	private UserStatus(int value, String info) {
		this.value = value;
		this.info = info;
	}

	public UserStatus get(int value) {
		for (UserStatus status : UserStatus.values()) {
			if (status.getValue() == value) {
				return status;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
