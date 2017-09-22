package cn.easted.edm.core.dao.ext;

import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.model.TAuthmanagement;

public interface TAuthmanagementMapperExt extends GenericDao<TAuthmanagement, Long> {
    String getMaxServerNumber();
}