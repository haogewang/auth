package cn.easted.edm.core.generic.enums;

/**
 * 软件产品类型:<br>
 */
public enum SoftWareProductType {

	CLOUD_OPTICAL_MONITOR(0L, "云光纤预警监控系统V1.0"), DESKTOP_VIRTUAL_V36(1L, "易讯通桌面系统虚拟化软件V3.6"),
	CLOUD_PLATFORM_V50(2L, "易讯通云平台系统V5.0"),VSTORAGE_MANAGE_V32(3L, "易讯通EASTED vStorage云存储管理系统V3.2.0"), 
	DATACENTER_MANAGE_V50(4L, "易讯通数据中心超融合云管理系统V5.0"),
	VSERVER_DATACENTER_V32(5L, "易讯通EASTED vServer虚拟数据中心系统V3.2"), VSERVER_DATACENTER_V32_MORE(6L, "易讯通EASTED vServer虚拟数据中心系统V3.2(增强版)"),
	CLOUD_VIRTUAL_PLATFORM_V50(7L, "易讯通EASTED云计算虚拟化平台软件V5.0"),CLOUD_VIRTUAL_PLATFORM_V50_MORE(8L, "易讯通EASTED云计算虚拟化平台软件V5.0(增强版)"),
	CLOUD_VIRTUAL_PLATFORM_V60(9L, "易讯通EASTED云计算虚拟化平台V6.0"),CLOUD_VIRTUAL_PLATFORM_V60_MORE(10L, "易讯通EASTED云计算虚拟化平台V6.0(增强版)"), 
	VSERVER_DATACENTER_V36(11L, "易讯通EASTED vServer虚拟数据中心系统V3.6"),VSERVER_DATACENTER_V36_MORE(12L, "易讯通EASTED vServer虚拟数据中心系统V3.6(增强版)"),
	DOCUMENT_CLOUD_V60(13L, "易讯通文档云系统V6.0");

	private long value;
	private String info;

	private SoftWareProductType(long value, String info) {
		this.value = value;
		this.info = info;
	}

	public SoftWareProductType get(long value) {
		for (SoftWareProductType type : SoftWareProductType.values()) {
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
