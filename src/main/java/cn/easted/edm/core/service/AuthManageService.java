/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年8月31日 上午10:48:51   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年8月31日 上午10:48:51  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.service;

import java.util.List;

import cn.easted.edm.core.generic.GenericService;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.model.TAuthmanagement;

/**
 * 权限管理接口
 * @ClassName:ContractService
 * @author:Wanghao
 * @date: 2017年8月31日 上午10:48:51
 */
public interface AuthManageService extends GenericService<TAuthmanagement, Long>{
	
	/**
	 * 分页
	 * @param auth auth
	 * @param page page
	 * @return
	 */
	public Page getPage(TAuthmanagement auth, Page page);
	/**
	 * 详情
	 * @param id id
	 * @return
	 */
	public TAuthmanagement selectById(Long id);

	/**
	 * 列表
	 * @return
	 */
	public List<TAuthmanagement> list();
	/**
	 * 获取最大服务号
	 * @return
	 */
	public String getMaxServerNumber();
	/**
	 * 批量插入
	 * @param list  
	 */
	public void insertBatch(List<TAuthmanagement> list);
	
}
