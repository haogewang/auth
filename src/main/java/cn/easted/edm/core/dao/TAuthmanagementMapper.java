package cn.easted.edm.core.dao;

import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.model.TAuthmanagement;
import cn.easted.edm.core.model.TAuthmanagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAuthmanagementMapper extends GenericDao<TAuthmanagement, Long> {
    int countByExample(TAuthmanagementExample example);

    int deleteByExample(TAuthmanagementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TAuthmanagement record);

    int insertSelective(TAuthmanagement record);

    List<TAuthmanagement> selectByExample(TAuthmanagementExample example);

    TAuthmanagement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAuthmanagement record, @Param("example") TAuthmanagementExample example);

    int updateByExample(@Param("record") TAuthmanagement record, @Param("example") TAuthmanagementExample example);

    int updateByPrimaryKeySelective(TAuthmanagement record);

    int updateByPrimaryKey(TAuthmanagement record);
}