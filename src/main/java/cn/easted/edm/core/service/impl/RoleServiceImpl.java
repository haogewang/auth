package cn.easted.edm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easted.edm.core.dao.TRoleMapper;
import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.generic.GenericServiceImpl;
import cn.easted.edm.core.model.TRole;
import cn.easted.edm.core.model.TRoleExample;
import cn.easted.edm.core.service.RoleService;
import cn.easted.edm.core.utils.LocalUtils;

@Service
public class RoleServiceImpl extends GenericServiceImpl<TRole, Long> implements RoleService {

	@Resource
	private TRoleMapper troleMapper;

	@Override
	public List<TRole> getRoleByIdList(String idList) {
		List<Long> ids = LocalUtils.idsToList(idList);
		if (ids == null)
			return null;
		if (ids.size() == 0)
			return null;

		TRoleExample exp = new TRoleExample();
		exp.createCriteria().andIdIn(ids);
		return troleMapper.selectByExample(exp);
	}

	@Override
	public GenericDao<TRole, Long> getDao() {
		// TODO Auto-generated method stub
		return troleMapper;
	}

	@Override
	public List<TRole> selectAll() {
		// TODO Auto-generated method stub
		return troleMapper.selectByExample(null);
	}

}
