package cn.easted.edm.core.generic.enums;

/**
 * 用户类型:<br>
 * LOCAL：0-本地用户<br>
 * DOMAIN：1-域用户
 * 
 * @author lei
 *
 */
public enum UserType {

	LOCAL(0L, "本地用户"), DOMAIN(1L, "域用户");

	private long value;
	private String info;

	private UserType(long value, String info) {
		this.value = value;
		this.info = info;
	}

	public UserType get(long value) {
		for (UserType type : UserType.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		return null;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
