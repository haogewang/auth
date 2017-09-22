/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年8月31日 下午1:58:48   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年8月31日 下午1:58:48  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支持跨域访问
 * @ClassName:CorsFilter
 * @author:Wanghao
 * @date: 2017年8月31日 下午1:58:48
 */
public class CorsFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response; 
		HttpServletRequest req = (HttpServletRequest) request;  
		res.setContentType("text/html;charset=UTF-8");  
//		   res.setHeader("Access-Control-Allow-Origin", "*");  
		   res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
		   res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		   res.setHeader("Access-Control-Max-Age", "0");  
		   res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
		   res.setHeader("Access-Control-Allow-Credentials", "true");  
		   res.setHeader("XDomainRequestAllowed","1");  
		   chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
