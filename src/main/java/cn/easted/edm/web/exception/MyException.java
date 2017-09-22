/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017-6-22 下午7:01:13   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.exception;
/**
 * 文件异常处理类
* @ClassName: FileException
* @author Wanghao
* @date 2017年6月23日 下午12:51:20
 */
public class MyException extends RuntimeException{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -5516334469690170748L;
	/**
	 * code码
	 */
	private String code;

	/**
	 * 构造器
	 * @param code code码
	 * @param msg  消息
	 */
	public MyException(String code, String msg) {
		super(msg);
		this.code = code;
	}
    /**
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
	
	

}
