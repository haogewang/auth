package cn.easted.edm.core.security;

/**
 * 权限标识配置类, <br>
 * 与 t_permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionSign.ADMIN_LOGIN)
 * public String create() {
 * 	return &quot;拥有user:admin_login权限,允许登录管理端&quot;;
 * }
 * </pre>
 * 
 * @author minqf
 * @since 2016年12月9日 下午23:58:51
 **/
public class PermissionSign {

	/**
	 * 用户新增权限 标识
	 */
	public static final String ADMIN_LOGIN = "user:admin_login";

	/**
	 * 用户删除权限 标识
	 */
	public static final String CLIENT_LOGIN = "user:client_login";

	/**
	 * 添加更多...
	 */

}
