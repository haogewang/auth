package cn.easted.edm.core.security;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import cn.easted.edm.core.generic.enums.UserSessionStatus;
import cn.easted.edm.core.model.TPermission;
import cn.easted.edm.core.model.TRole;
import cn.easted.edm.core.model.TUser;
import cn.easted.edm.core.service.PermissionService;
import cn.easted.edm.core.service.RoleService;
import cn.easted.edm.core.service.UserService;
import cn.easted.edm.core.utils.DESUtil;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author minqf
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Resource
	private RoleService roleService;

	@Resource
	private PermissionService permissionService;

	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());

		final TUser user = userService.getUserByName(username, 0L);
		final List<TRole> roleInfos = roleService.getRoleByIdList(user.getUserroles());
		for (TRole role : roleInfos) {
			// 添加角色
			authorizationInfo.addRole(role.getRoleSign());

			final List<TPermission> permissions = permissionService.getPermissionsByIdList(role.getRolepermissions());
			for (TPermission permission : permissions) {
				// 添加权限
				authorizationInfo.addStringPermission(permission.getPermissionSign());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
		UserToken token = (UserToken) authtoken;
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		String key = token.getKey();
		String signature = token.getSignature();
		String domain = token.getDomain();
		TUser authentication = null;
		if (StringUtils.isEmpty(key) && StringUtils.isEmpty(signature)) {
			// 通过数据库进行验证
			authentication = userService.userValidate(username, password, 0L);
			if (authentication == null) {
				throw new AuthenticationException("用户名或密码错误.");
			}
		} else {
			try {
				if (signature.equals(DESUtil.encrypt(key, ""))) {
					userService.updateSessionstatusStatus(username, domain, UserSessionStatus.ONLINE);
				} else {
					throw new AuthenticationException();
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 身份验证失败
				throw new AuthenticationException("501");
			}
			List<TUser> users = userService.getUserByNameDomain(username, domain);
			if (null == users || users.size() < 1) {
				// 用户名域验证失败
				throw new AuthenticationException("502");
			}

			// authentication=userService.userValidateForApi(username, eid,
			// userUUID, domain);
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
		return authenticationInfo;
	}

}
