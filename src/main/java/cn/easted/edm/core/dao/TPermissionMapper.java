package cn.easted.edm.core.dao;

import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.model.TPermission;
import cn.easted.edm.core.model.TPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPermissionMapper extends GenericDao<TPermission, Long> {
	int countByExample(TPermissionExample example);

	int deleteByExample(TPermissionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TPermission record);

	int insertSelective(TPermission record);

	List<TPermission> selectByExample(TPermissionExample example);

	TPermission selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TPermission record, @Param("example") TPermissionExample example);

	int updateByExample(@Param("record") TPermission record, @Param("example") TPermissionExample example);

	int updateByPrimaryKeySelective(TPermission record);

	int updateByPrimaryKey(TPermission record);
}