package cn.easted.edm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easted.edm.core.dao.TPermissionMapper;
import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.generic.GenericServiceImpl;
import cn.easted.edm.core.model.TPermission;
import cn.easted.edm.core.model.TPermissionExample;
import cn.easted.edm.core.service.PermissionService;
import cn.easted.edm.core.utils.LocalUtils;

@Service
public class PermissionServiceImpl extends GenericServiceImpl<TPermission, Long> implements PermissionService {

	@Resource
	private TPermissionMapper tpermissionMapper;

	@Override
	public List<TPermission> getPermissionsByIdList(String idList) {
		List<Long> ids = LocalUtils.idsToList(idList);
		if (ids == null)
			return null;

		TPermissionExample exp = new TPermissionExample();
		exp.createCriteria().andIdIn(ids);
		return tpermissionMapper.selectByExample(exp);
	}

	@Override
	public GenericDao<TPermission, Long> getDao() {
		return tpermissionMapper;
	}

	@Override
	public List<TPermission> selectAll() {
		return tpermissionMapper.selectByExample(null);
	}
}
