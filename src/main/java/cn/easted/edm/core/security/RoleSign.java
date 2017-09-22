package cn.easted.edm.core.security;

/**
 * 角色标识配置类, <br>
 * 与 role_info 角色表中的 role_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresRoles(value = RoleSign.ADMIN)
 * public String admin() {
 * 	return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 * @author StarZou
 * @since 2014年6月17日 下午3:58:51
 **/
public class RoleSign {

	/**
	 * 超级管理员
	 */
	public static final String ADMIN = "admin";

	/**
	 * 仅允许访问桌面
	 */
	public static final String CLIENT = "client";

	/**
	 * 添加更多...
	 */

}
