package cn.easted.edm.core.service;

import java.util.List;

import cn.easted.edm.core.generic.GenericService;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.generic.enums.UserSessionStatus;
import cn.easted.edm.core.model.TUser;

/**
 * 用户操作service
 * 
 * @author: lei
 * @Date: 2016年12月30日 上午11:58:40
 */
public interface UserService extends GenericService<TUser, Long> {

	public Page getPage(TUser user, Page page);
	TUser userValidate(String userName, String passwd, Long userType);
	public TUser getUserByName(String userName, Long userType);
	public Integer updatePassword(String username, String password);
	public Integer updateSessionstatusStatus(String username, String domain, UserSessionStatus userSessionStatus);
	public List<TUser> getUserByNameDomain(String userName, String domain);
}
