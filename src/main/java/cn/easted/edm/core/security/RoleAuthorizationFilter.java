/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年3月3日 下午3:48:36   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * @author: lei
 * @Date: 2017年3月3日 下午3:48:36
 */
public class RoleAuthorizationFilter extends FormAuthenticationFilter {

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		Subject subject = getSubject(request, response);
		if (subject.getPrincipal() == null) {
			if (((HttpServletRequest) request).getRequestURI().contains("edmapi")) {
				sendFastJson(response, "503");
			} else {
				saveRequestAndRedirectToLogin(request, response);
				//HttpServletResponse res = (HttpServletResponse) response;
				//res.setStatus(401);
				
			}
		} else {
			if (((HttpServletRequest) request).getRequestURI().contains("edmapi")) {
				sendFastJson(response, "504");
			} else {
				saveRequestAndRedirectToLogin(request, response);
//				HttpServletResponse res = (HttpServletResponse) response;
//				res.setStatus(401);
			}
		}
		return false;
	}

	public void sendFastJson(ServletResponse response, String jsonStr) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
