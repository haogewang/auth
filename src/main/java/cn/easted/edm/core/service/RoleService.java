package cn.easted.edm.core.service;

import java.util.List;

import cn.easted.edm.core.generic.GenericService;
import cn.easted.edm.core.model.TRole;

public interface RoleService extends GenericService<TRole, Long> {
	List<TRole> getRoleByIdList(String idList);
}
