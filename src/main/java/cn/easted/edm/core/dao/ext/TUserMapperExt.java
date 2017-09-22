package cn.easted.edm.core.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easted.edm.core.generic.GenericDao;
import cn.easted.edm.core.model.TUser;
import cn.easted.edm.core.model.TUserExample;

public interface TUserMapperExt extends GenericDao<TUser, Long> {

	/**
	 * 获取未分配资源的用户
	 * 
	 * @param record
	 * @return
	 * @author lei
	 */
	List<TUser> getUndistributedResUser();

	/**
	 * 通过用户名和新密码更新密码
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	Integer updatePwdByUserName(@Param("username") String username, @Param("password") String password);

	/**
	 * 查询出系统中所有的域
	 * 
	 * @return
	 * @author lei
	 */
	List<String> selectDomainsByUser();

	/**
	 * 查询出Domainentryid不重复的用户的个数
	 * 
	 * @param example
	 * @return
	 * @author lei
	 */
	int countByExampleGroupByDomainentryid(TUserExample example);

	/**
	 * 查询出Domainentryid不重复的用户列表
	 * 
	 * @param example
	 * @return
	 * @author lei
	 */
	List<TUser> selectByExampleGroupByDomainentryid(TUserExample example);

	/**
	 * 根据username、domain 修改用户状态
	 * 
	 * @param username
	 * @param domain
	 * @param sessionstatus
	 * @return
	 * @author lei
	 */
	public Integer updateSessionstatusStatus(@Param("username") String username, @Param("domain") String domain,
			@Param("sessionstatus") Integer sessionstatus);

	/**
	 * 根据t_cient_User表中数据同步离线用户的状态
	 * 
	 * @return
	 * @author lei
	 */
	public Integer asyncSessionstatusStatus(@Param("sessionstatus") Integer sessionstatus);

	/**
	 * 根据domainentryid去重复
	 * 
	 * @return
	 * @author yiny
	 */
	Integer countTUserByDomainentryid();

	/**
	 * 根据用户id查询出和此用户名称、域名完全相同的用户
	 * 
	 * @param id
	 * @return
	 * @author lei
	 */
	List<Long> selectUserByid(Long id);
}