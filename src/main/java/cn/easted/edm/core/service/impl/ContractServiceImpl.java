/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年8月31日 上午10:56:40   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年8月31日 上午10:56:40  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.easted.edm.core.dao.TAuthmanagementMapper;
import cn.easted.edm.core.dao.ext.TAuthmanagementMapperExt;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.model.TAuthmanagement;
import cn.easted.edm.core.model.TAuthmanagementExample;
import cn.easted.edm.core.service.AuthManageService;
import cn.easted.edm.web.exception.MyException;

/**
 * 合同管理实现类
 * @ClassName:ContractServiceImpl
 * @author:Wanghao
 * @date: 2017年8月31日 上午10:56:40
 */
@Service
public class ContractServiceImpl implements AuthManageService{

	/**
	 * tauthMapper
	 */
	@Resource
	private TAuthmanagementMapper tauthMapper;
	@Resource
	private TAuthmanagementMapperExt tauthMapperExt;

	@Override
	public Page getPage(TAuthmanagement hetong, Page page) {
		TAuthmanagementExample exp = new TAuthmanagementExample();
//		Criteria criteria = exp.createCriteria();
		if (StringUtils.isNotBlank(page.getSearch())){
			TAuthmanagementExample.Criteria c1 = exp.createCriteria();
			c1.andAuthorizationcodeLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c2 = exp.createCriteria();
			c2.andTypeLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c3 = exp.createCriteria();
			c3.andNameLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c4 = exp.createCriteria();
			c4.andProductLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c5 = exp.createCriteria();
			c5.andSerinumberLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c6 = exp.createCriteria();
			Pattern p = Pattern.compile(".*\\d+.*");    
			Matcher m = p.matcher(page.getSearch());
			if (m.matches()){
				c6.andVersionLike(page.getSearch());
			}
			TAuthmanagementExample.Criteria c7 = exp.createCriteria();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (hetong.getDate() != null){
				try {
					c7.andDateEqualTo(hetong.getDate());
				} catch (Exception e) {
					throw new MyException("100", "日期格式不正确");
				}
			}
			
			TAuthmanagementExample.Criteria c8 = exp.createCriteria();
			c8.andServernumberLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c9 = exp.createCriteria();
			c9.andAuthTimeoutLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c10 = exp.createCriteria();
			c10.andAclientLike("%" + page.getSearch() + "%");
			TAuthmanagementExample.Criteria c11 = exp.createCriteria();
			c11.andBclientMachinecodeLike("%" + page.getSearch() + "%");
			
			exp.or(c1);
			exp.or(c2);
			exp.or(c3);
			exp.or(c4);
			exp.or(c5);
			exp.or(c6);
			exp.or(c9);
			exp.or(c8);
			exp.or(c10);
			exp.or(c11);
			
		}
		TAuthmanagementExample.Criteria c7 = exp.createCriteria();
		if ( hetong.getStatus() != null && hetong.getStatus() == 0){
			c7.andStatusEqualTo((short)0);
		} else if ( hetong.getStatus() != null && hetong.getStatus() == 1){
			c7.andStatusEqualTo((short)1);
		}
		exp.or(c7);
		
		exp.setLimit(page.getLimit());
		exp.setOffset(page.getOffset());
		page.setOrderName("date");
		page.setOrder("asc");
		exp.setOrderByClause(page.getOrderName() + " " + page.getOrder());
		if (!StringUtils.isBlank(page.getOrderName()) && !StringUtils.isBlank(page.getOrder())) {
			exp.setOrderByClause(page.getOrderName() + " " + page.getOrder());
		}
		List<TAuthmanagement> contractList = tauthMapper.selectByExample(exp);
		
		page.setDataList(contractList);
		page.setCountAll(tauthMapper.countByExample(null));
		page.setCount(tauthMapper.countByExample(exp));
		return page;
	}

	@Override
	public TAuthmanagement selectById(Long id) {
		return tauthMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<TAuthmanagement> list() {
		List<TAuthmanagement> list = tauthMapper.selectByExample(null);
		return list;
	}


	@Override
	public int insert(TAuthmanagement ht) {
		return tauthMapper.insertSelective(ht);
	}

	@Override
	public int update(TAuthmanagement ht) {
		return tauthMapper.updateByPrimaryKeySelective(ht);
	}

	@Override
	public int delete(Long id) {
		return tauthMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TAuthmanagement> selectAll() {
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.easted.edm.core.service.AuthManageService#getMaxServerNumber()
	 */
	@Override
	public String getMaxServerNumber() {
		String number = tauthMapperExt.getMaxServerNumber();
		return number;
	}

	
	@Override
	public void insertBatch(List<TAuthmanagement> list) {
		for (TAuthmanagement auth :list){
			insert(auth);
		}
	}

}
