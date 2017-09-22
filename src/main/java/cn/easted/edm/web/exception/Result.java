/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017-6-22 下午7:01:13   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.exception;
/**
 * 异常结果实体类
* @ClassName: Result
* @author Wanghao
* @date 2017年6月23日 下午12:52:00
* @param <T>
 */
public class Result<T> {

	/**
	 * 错误代码
	 */
	private String code;

	/**
	 * 	错误消息
	 */
	private String msg;

	/**
	 * 数据
	 */
	private T data;
	/**
	 * 
	* @return String
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 
	* @param code code码
	* void
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	* @return  String
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 
	* @param msg 消息
	* void
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 数据
	* @return
	* T
	 */
	public T getData() {
		return data;
	}
	/**
	 * 
	* @param data 数据
	* void
	 */
	public void setData(T data) {
		this.data = data;
	}
	
}
