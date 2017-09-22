package cn.easted.edm.core.generic.enums;

/**
 * 用户在线、离线状态<br>
 * OFFLINE：0-离线<br>
 * ONLINE：1-在线
 * 
 * @author lei
 *
 */
public enum UserSessionStatus {

	OFFLINE(0, "离线"), ONLINE(1, "在线");

	private int value;
	private String info;

	private UserSessionStatus(int value, String info) {
		this.value = value;
		this.info = info;
	}

	/**
	 * 根据value获取对应的枚举
	 * 
	 * @param value
	 * @return
	 * @author lei
	 */
	public UserSessionStatus get(int value) {
		for (UserSessionStatus status : UserSessionStatus.values()) {
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
