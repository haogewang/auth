package cn.easted.edm.core.service;

import java.util.List;

import cn.easted.edm.core.generic.GenericService;
import cn.easted.edm.core.model.TPermission;

public interface PermissionService extends GenericService<TPermission, Long> {
	List<TPermission> getPermissionsByIdList(String idList);
}
