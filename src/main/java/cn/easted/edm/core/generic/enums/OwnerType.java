package cn.easted.edm.core.generic.enums;

/**
 * Owner类型:<br>
 * USER：0-用户<br>
 * GROUP：1-用户组
 * 
 * @author lei
 *
 */
public enum OwnerType {

	USER(1L, "用户"), GROUP(2L, "用户组");

	private long value;
	private String info;

	private OwnerType(long value, String info) {
		this.value = value;
		this.info = info;
	}

	public OwnerType get(long value) {
		for (OwnerType type : OwnerType.values()) {
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
