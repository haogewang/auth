/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2016年12月27日 下午4:57:42   
 * @version V1.0 
 * @Copyright: 2016 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @Author: minqf
 * @Date: 2016年12月27日 下午4:28:34
 */
@Controller
@RequestMapping("/page")
public class PageController {
	/**
	 * 404页
	 * 
	 * @param @return
	 * @return String
	 * @author minqf
	 */
	@RequestMapping("/404")
	public String error404() {
		return "404";
	}

	/**
	 * 401页
	 * 
	 * @param @return
	 * @return String
	 * @author minqf
	 */
	@RequestMapping("/401")
	public String error401() {
		return "401";
	}

	/**
	 * 500页
	 * 
	 * @param @return
	 * @return String
	 * @author minqf
	 */
	@RequestMapping("/500")
	public String error500() {
		return "500";
	}

}