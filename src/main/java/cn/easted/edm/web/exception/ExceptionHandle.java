/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017-6-22 下午7:01:13   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获处理类
* @ClassName: ExceptionHandle
* @author Wanghao
* @date 2017年6月23日 下午12:50:06
 */
@ControllerAdvice
public class ExceptionHandle {

	/**
	 * 异常处理方法
	* @param e 异常
	* @return Result<?>
	* @author Wanghao
	 */
	//@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<?> handle(Exception e){
		if (e instanceof MyException){
			return ResultUtil.error(((MyException) e).getCode(), e.getMessage());
		} else {
			return ResultUtil.error("100", e.getMessage());
		}
	}
}
