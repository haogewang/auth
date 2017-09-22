/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年2月22日 下午2:39:32   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.fastjson.argumentResolver;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.easted.edm.core.utils.LocalUtils;

/**
 * @author: lei
 * @Date: 2017年2月22日 下午2:39:32
 */
public class FastJsonArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(FastJson.class) != null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		// content-type不是json的不处理
		if (null != request.getContentType() && !request.getContentType().contains("application/json")
				&& !request.getContentType().contains("application/x-www-form-urlencoded")) {
			return null;
		}

		StringBuilder sb = new StringBuilder("{");
		
		String orderName = null;
		Map<String, String[]> map = request.getParameterMap();
		Object obj = map.get("orderName");
		if (obj != null){
			orderName = ((String[]) obj)[0].toString();
			//System.out.println(orderName);
			orderName = LocalUtils.beanToField(orderName);
		}
		Set<?> keSet = map.entrySet();
		for (Iterator<?> itr = keSet.iterator(); itr.hasNext();) {
			Map.Entry me = (Map.Entry) itr.next();
			Object key = me.getKey();
			if (!"orderName".equals(key)){
				sb.append("\"" + key.toString() + "\":");
				Object ov = me.getValue();
				//System.out.println(key+":"+ov.toString());
				if (ov instanceof String[]) {
					sb.append("\"" + ((String[]) ov)[0].toString() + "\",");
				} else {
					sb.append("\"" + ov.toString() + "\",");
				}
			}
		}
		sb.append("\"orderName\":");
		sb.append("\"" + orderName + "\":");
		sb = sb.delete(sb.length() - 1, sb.length());
		sb.append("}");
		//System.out.println("sb:"+sb);
		// 利用fastjson转换为对应的类型
		if (JSONObject.class.isAssignableFrom(parameter.getParameterType())) {
			return JSON.parseObject(sb.toString());
		} else {
			return JSON.parseObject(sb.toString(), parameter.getParameterType());
		}
	}

}
