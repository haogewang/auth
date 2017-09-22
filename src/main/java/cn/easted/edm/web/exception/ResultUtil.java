/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017-6-22 下午7:01:13   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.exception;
/**
 * 结果工具类
* @ClassName: ResultUtil
* @author Wanghao
* @date 2017年6月23日 下午5:08:39
 */
public class ResultUtil {
	/**
	 * 成功时调用此方法
	* @param code code码
	* @param data  数据
	* @return
	* Result
	* @author Wanghao
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(String code, Object data){
		Result result = new Result();
		result.setCode(code);
		result.setData(data);
		result.setMsg("success");
		return result;
	}
	/**
	 * 错误时调用此方法
	* @param code code码 
	* @param msg  消息
	* @return
	* Result
	* @author Wanghao
	 */
	@SuppressWarnings("rawtypes")
	public static Result error(String code, String msg){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
