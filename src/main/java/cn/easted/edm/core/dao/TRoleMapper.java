package cn.easted.edm.core.dao;

import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.model.TRole;
import cn.easted.edm.core.model.TRoleExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMapper extends GenericDao<TRole, Long> {
	int countByExample(TRoleExample example);

	int deleteByExample(TRoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TRole record);

	int insertSelective(TRole record);

	List<TRole> selectByExample(TRoleExample example);

	TRole selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

	int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

	int updateByPrimaryKeySelective(TRole record);

	int updateByPrimaryKey(TRole record);
}