package cn.easted.edm.core.generic.enums;

/**
 * 规格型号:<br>
 * 
 */
public enum CompactVersion {

	EASTED_HCI(0L, "EASTED HCI"), ECloud_Data_Platform(1L, "ECloud Data Platform"), EASTED_ECloud(2L, "EASTED ECloud"),
	EASTED_VServer(3L, "EASTED vServer"), EASTED_View(4L, "EASTED View"), EASTED_EVO(5L, "EASTED EVO"), 
	EASTED_ThinApp(6L, "EASTED ThinApp"), EASTED_Desktop_Cloud_Integrated_Machine(7L, "EASTED Desktop Cloud Integrated Machine"), EASTED_VNet(8L, "EASTED vNet"),
	EASTED_Cloud_Server(9L, "EASTED Cloud Server"), EASTED_Cloud_Storage(10L, "EASTED Cloud Storage"), EASTED_COMS(11L, "EASTED COMS"), EASTED_VStorage(12L, "EASTED vStorage"),

	CLOUD_OPTICAL_MONITOR(11L, "云光纤预警监控系统V1.0"), DESKTOP_VIRTUAL_V36(12L, "易讯通桌面系统虚拟化软件V3.6"),
	CLOUD_PLATFORM_V50(13L, "易讯通云平台系统V5.0"),VSTORAGE_MANAGE_V32(14L, "易讯通EASTED vStorage云存储管理系统V3.2.0"), 
	DATACENTER_MANAGE_V50(15L, "易讯通数据中心超融合云管理系统V5.0"),
	VSERVER_DATACENTER_V32(16L, "易讯通EASTED vServer虚拟数据中心系统V3.2"), VSERVER_DATACENTER_V32_MORE(17L, "易讯通EASTED vServer虚拟数据中心系统V3.2(增强版)"),
	CLOUD_VIRTUAL_PLATFORM_V50(18L, "易讯通EASTED云计算虚拟化平台软件V5.0"),CLOUD_VIRTUAL_PLATFORM_V50_MORE(19L, "易讯通EASTED云计算虚拟化平台软件V5.0(增强版)"),
	CLOUD_VIRTUAL_PLATFORM_V60(20L, "易讯通EASTED云计算虚拟化平台V6.0"),CLOUD_VIRTUAL_PLATFORM_V60_MORE(21L, "易讯通EASTED云计算虚拟化平台V6.0(增强版)"), 
	VSERVER_DATACENTER_V36(22L, "易讯通EASTED vServer虚拟数据中心系统V3.6"),VSERVER_DATACENTER_V36_MORE(23L, "易讯通EASTED vServer虚拟数据中心系统V3.6(增强版)"),
	ECenter(24L, "ECente"), Receiver (25L, "Receiver"), STANDED (26L, "标准版 "),EDUCTION (27L, "教育版"),SCIENSE (28L, "科研版"),SDDC (28L, "SDDC");
	
	private long value;
	private String info;

	private CompactVersion(long value, String info) {
		this.value = value;
		this.info = info;
	}

	public CompactVersion get(long value) {
		for (CompactVersion type : CompactVersion.values()) {
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
