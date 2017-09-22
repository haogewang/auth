/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年2月10日 上午11:49:33   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.generic.enums;

/**
 * @author: yinyong
 * @Date: 2017年2月10日 上午11:49:33
 */
public enum AdminOperationType {
	MODIF_PASSWORD("MODIF_PASSWORD", "修改密码"), LOGIN("LOGIN", "登录"), LOGOUT("LOGOUT", "登出");
	private String value;
	private String info;

	private AdminOperationType(String value, String info) {
		this.value = value;
		this.info = info;
	}

	public AdminOperationType get(String value) {
		for (AdminOperationType adminOperationType : AdminOperationType.values()) {
			if (adminOperationType.getValue().equals(value)) {
				return adminOperationType;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
