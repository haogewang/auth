/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2016年12月27日 下午4:57:42   
 * @version V1.0 
 * @Copyright: 2016 Beijing Easted Technology Co.,LTD All rights reserved.
 */
package cn.easted.edm.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.easted.edm.core.model.TUser;
import cn.easted.edm.core.security.UserToken;
import cn.easted.edm.core.service.UserService;
import cn.easted.edm.web.exception.Result;
import cn.easted.edm.web.exception.ResultUtil;




/**
 * 公共视图控制器
 * 
 * @author minqf
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {
	private static Logger logger = Logger.getLogger(CommonController.class);
	@Resource
	private UserService userService;
	@Resource
	private org.apache.shiro.mgt.SecurityManager securityManager;


	/**
	 * 首页
	 * 
	 * @param request
	 *            request
	 * @return String
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// 未登录时退回到登录页
		Subject subject = SecurityUtils.getSubject();
		if (subject.getSession() == null) {
			return "login";
		}
		if (!subject.isAuthenticated()) {
			return "login";
		}
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		// 未登录时退回到登录页
		Subject subject = SecurityUtils.getSubject();
		if (subject.getSession() == null) {
			return "login";
		}
		if (!subject.isAuthenticated()) {
			return "login";
		}
		return "index";
	}
	


	/**
	 * 用户登录
	 * 
	 * @param tuser
	 *            用户
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 * @author lei
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> login(@Valid TUser tuser, BindingResult result, Model model, HttpServletRequest request) {
		if (request.getMethod().equals(RequestMethod.GET.toString())) {
			//return "login";
			return ResultUtil.error("100", "请求路径错误");
		}
		try {
			Subject subject = SecurityUtils.getSubject();
			// 已登陆则 跳到首页
			if (subject.isAuthenticated()) {
//				return "redirect:/";
				return ResultUtil.success("200", "");
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "* 用户名或密码错误！");
				//return "login";
				return ResultUtil.error("100", "用户名或密码错误");
			}
			// 身份验证
			subject.login(new UserToken(tuser.getUsername(), tuser.getPassword(), true));
			// 验证成功在Session中保存用户信息
			final TUser authUserInfo = userService.getUserByName(tuser.getUsername(), tuser.getType());
			request.getSession().setAttribute("userInfo" + authUserInfo.getUsername(), authUserInfo);
//			TDict dict = dictService.selectDictByKey(Constant.IS_POLICY_USE);
//			if (dict == null) {
//				dict = new TDict();
//				dict.setValue("0");
//			}
//			request.getSession().setAttribute("dic", dict.getValue());
		} catch (AuthenticationException e) {
			// 身份验证失败
			model.addAttribute("error", "* 用户名或密码错误 ！");
			//return "login";
			return ResultUtil.error("100", "用户名或密码错误");
		}
		// redirectAttributes.addFlashAttribute("message","用户名或密码错误");
		logger.info(tuser.getUsername() + " 登录系统。");
//		logService.saveAdmin(AdminOperationType.LOGIN);
//		return "redirect:/#Dashboard";
		return ResultUtil.success("200", "");
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 * @author lei
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Result<?> logout(HttpSession session) {
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		if (subject.getSession() != null) {
			TUser user = (TUser) subject.getSession().getAttribute("userInfo");
			if (user != null)
				logger.info(user.getUsername() + " 退出系统。");
//			logService.saveAdmin(AdminOperationType.LOGOUT);
			subject.logout();
		}
		try {
			session.removeAttribute("userInfo");
		} catch (Exception e) {
		}
		//return "redirect:/login";
		return ResultUtil.success("200", "");
	}
}