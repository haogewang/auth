package cn.easted.edm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.easted.edm.core.dao.TUserMapper;
import cn.easted.edm.core.dao.ext.TUserMapperExt;
import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.generic.GenericServiceImpl;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.generic.enums.UserSessionStatus;
import cn.easted.edm.core.model.TUser;
import cn.easted.edm.core.model.TUserExample;
import cn.easted.edm.core.service.UserService;
import cn.easted.edm.core.utils.LocalUtils;

@Service
public class UserServiceImpl extends GenericServiceImpl<TUser, Long> implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private TUserMapper tuserMapper;

	@Resource
	private TUserMapperExt tuserMapperExt;

	@Override
	public TUser userValidate(String userName, String passwd, Long userType) {
		if (LocalUtils.nullOrEmpty(userName))
			return null;
		if (LocalUtils.nullOrEmpty(passwd))
			return null;
		TUserExample exp = new TUserExample();
		if (userType == 0L) {
			// 本地用户密码是通过SHA256加密存储的，需要加密后验证
			exp.createCriteria().andUsernameEqualTo(userName.toLowerCase())
					.andPasswordEqualTo(LocalUtils.StrEncrypt(passwd, "")).andTypeEqualTo(userType);
		} else {
			// 暂时不支持vServer用户做管理员，以后可以考虑将api接口工厂注入到这个Service中实现vServer用户认证。
			return null;
		}

		List<TUser> list = tuserMapper.selectByExample(exp);
		if (LocalUtils.nullOrEmpty(list))
			return null;

		return list.get(0);
	}

	@Override
	public GenericDao<TUser, Long> getDao() {
		return tuserMapper;
	}

	@Override
	public List<TUser> selectAll() {
		return tuserMapper.selectByExample(null);
	}

	@Override
	public TUser getUserByName(String userName, Long userType) {
		if (LocalUtils.nullOrEmpty(userName))
			return null;

		TUserExample exp = new TUserExample();
		exp.createCriteria().andUsernameEqualTo(userName.toLowerCase());

		List<TUser> list = tuserMapper.selectByExample(exp);
		if (LocalUtils.nullOrEmpty(list))
			return null;
		logger.info("");
		return list.get(0);
	}

	

	@Override
	public Page getPage(TUser user, Page page) {
		TUserExample userexam = new TUserExample();
		cn.easted.edm.core.model.TUserExample.Criteria crUserName = userexam.createCriteria();
		cn.easted.edm.core.model.TUserExample.Criteria crNickName = userexam.createCriteria();
		if (null != user) {
			if (!StringUtils.isEmpty(user.getUsername())) {
				crUserName.andUsernameLike("%" + user.getUsername() + "%");
				crNickName.andNicknameLike("%" + user.getUsername() + "%");
			}
			if (!StringUtils.isEmpty(user.getSessionstatus())) {
				crUserName.andSessionstatusEqualTo(user.getSessionstatus());
				crNickName.andSessionstatusEqualTo(user.getSessionstatus());
			}

		}
		userexam.or(crUserName);
		userexam.or(crNickName);
		userexam.setOffset(page.getOffset());
		userexam.setLimit(page.getLimit());
		if (StringUtils.isNotBlank(page.getOrderName()) && StringUtils.isNotBlank(page.getOrder())) {
			userexam.setOrderByClause(page.getOrderName() + " "+ page.getOrder());
		}
		page.setDataList(tuserMapperExt.selectByExampleGroupByDomainentryid(userexam));
		page.setCount(tuserMapperExt.countByExampleGroupByDomainentryid(userexam));
		page.setCountAll(tuserMapper.countByExample(null));
		return page;
	}

	@Override
	public Integer updatePassword(String username, String password) {
		if (password != "") {

			Integer i = tuserMapperExt.updatePwdByUserName(username, LocalUtils.StrEncrypt(password, ""));
			return i;
		}
		return 0;
	}
	@Override
	public List<TUser> getUserByNameDomain(String userName, String domain) {

		if (LocalUtils.nullOrEmpty(userName))
			return null;

		TUserExample exp = new TUserExample();
		exp.createCriteria().andUsernameEqualTo(userName).andDomainEqualTo(domain);

		List<TUser> list = tuserMapper.selectByExample(exp);
		if (LocalUtils.nullOrEmpty(list))
			return null;

		return list;

	}
	
	@Override
	public Integer updateSessionstatusStatus(String username, String domain, UserSessionStatus userSessionStatus) {
		return tuserMapperExt.updateSessionstatusStatus(username, domain, userSessionStatus.getValue());
	}

}
