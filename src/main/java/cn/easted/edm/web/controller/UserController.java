/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2016年12月27日 下午4:57:42   
 * @version V1.0 
 * @Copyright: 2016 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import cn.easted.edm.core.fastjson.argumentResolver.FastJson;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.generic.enums.AdminOperationType;
import cn.easted.edm.core.generic.enums.UserType;
import cn.easted.edm.core.model.TUser;
import cn.easted.edm.core.service.UserService;
import cn.easted.edm.web.exception.ResultUtil;

/**
 * 用户操作Controller
 * 
 * @author: lei
 * @date: 2016年12月27日 下午4:30:07
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;
	@Resource
	private org.apache.shiro.mgt.SecurityManager securityManager;

	

	/**
	 * 跳到新增本地用户页面
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @author lei
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String add(TUser user, Model model, @FastJson Page page) {
		user = new TUser();
		SimplePropertyPreFilter fifler = new SimplePropertyPreFilter(TUser.class);
		fifler.getIncludes().add("id");
		fifler.getIncludes().add("phone");
		fifler.getIncludes().add("nickname");
		fifler.getIncludes().add("username");
		fifler.getIncludes().add("email");
		fifler.getIncludes().add("type");
		fifler.getIncludes().add("status");
		fifler.getIncludes().add("domain");
		return JSON.toJSONString(user, fifler, SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty);
	}

	/**
	 * 获取分页数据
	 * 
	 * @param user
	 * @param page
	 * @return
	 * @author lei
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody String userlList(@FastJson TUser user, @FastJson Page page, Model model) {
		user.setType(UserType.DOMAIN.getValue());
		page = userService.getPage(user, page);
		//List<TLog> list = (List<TLog>) page.getDataList();
		// model.addAttribute("page", page);
		return JSON.toJSONString(ResultUtil.success("200",page));
	}

	/**
	 * 跳到修改用户页面
	 * 
	 * @param id
	 *            id为null到新增页面，不为空道修改页面
	 * @param model
	 * @return
	 * @author lei
	 */
	

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable Long id, Model model) {
		int i = userService.delete(id);
		return JSON.toJSONString(i > 0);
	}

	/**
	 * 新增本地用户
	 * 
	 * @param user
	 * @return
	 * @author lei
	 */

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody String add(TUser user) {
		if (user == null) {
			return JSON.toJSONString(false);
		}
		user.setDomain("");
		int i = userService.insert(user);
		return JSON.toJSONString(i > 0);
	}

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
	 * 
	 * @Override public void setAsText(String value) { setValue(new
	 * Date(Long.valueOf(value))); } });
	 * 
	 * }
	 */

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @param req
	 * @return
	 * @author lei
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody String update(TUser user, HttpServletRequest req) {
		if (user == null || user.getId() == null) {
			return JSON.toJSONString(Boolean.FALSE);
		}
		int i = userService.update(user);
		return JSON.toJSONString(i > 0);
	}



	/**
	 * 修改密码
	 * 
	 * @param username
	 *            用户名
	 * @param oldPwd
	 *            旧密码
	 * @param newPwd
	 *            新密码
	 * @param session
	 * @param MODIF_PASSWORD
	 *            修改密码
	 * @return
	 * @author wangdn
	 */
	@RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
	public @ResponseBody String updatePassword(String username, String oldPwd, String newPwd, HttpSession session,
			AdminOperationType MODIF_PASSWORD) {
		// System.out.println(username+":"+oldPwd+"--"+newPwd);
		TUser user = userService.userValidate(username, oldPwd, 0L);

		if (user != null) {
			Integer i = userService.updatePassword(username, newPwd);
			if (i == 0) {
				return JSON.toJSONString(ResultUtil.error("100","* 修改失败！"));
			} else {
				Subject subject = SecurityUtils.getSubject();
				if (subject.getSession() != null) {
					TUser user1 = (TUser) subject.getSession().getAttribute("userInfo");
					if (user1 != null)
						logger.info(user.getUsername() + " 退出系统。");
//					logService.saveAdmin(AdminOperationType.MODIF_PASSWORD);
					subject.logout();

				}
				try {
					session.removeAttribute("userInfo");
				} catch (Exception e) {
				}
				return JSON.toJSONString(ResultUtil.success("200","* 修改成功！"));
			}
		}
		return JSON.toJSONString(ResultUtil.error("100","* 旧密码不正确！"));

	}

}
