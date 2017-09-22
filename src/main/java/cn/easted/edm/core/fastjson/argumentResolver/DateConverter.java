/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年2月23日 下午2:10:56   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.fastjson.argumentResolver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * @author: lei
 * @Date: 2017年2月23日 下午2:10:56
 */
public class DateConverter implements Converter<String, Date> {

	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat TIMEFORMAT2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang.
	 * Object)
	 */
	public Date convert(String source) {
		if (!StringUtils.hasText(source)) {
			return null;
		}

		try {
			SimpleDateFormat dateFormat = getDateFormat(source);
			dateFormat.setLenient(false);
			return dateFormat.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 功能：用本地的三种日期格式实例化出DateFormat对象
	 *
	 * @param value
	 *            待解析的值
	 * @return DateFormat对象
	 */
	private SimpleDateFormat getDateFormat(String value) {
		SimpleDateFormat dateFormat = null;

		Pattern patter = null;
		Matcher matcher = null;
		String formatter = null;

		try {
			// ^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$
			// yyyy-mm-dd
			patter = Pattern.compile("^\\d{4}\\-\\d{1,2}\\-\\d{1,2}$");
			matcher = patter.matcher(value);
			if (matcher.matches()) {
				dateFormat = DATEFORMAT;
				formatter = "yyyy-mm-dd";
				// System.out.println("yyyy-mm-dd");
				return dateFormat;
			}

			// yyyy-MM-dd HH:mm:ss
			patter = Pattern.compile("^\\d{4}\\-\\d{1,2}\\-\\d{1,2}\\s{1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
			matcher = patter.matcher(value);
			if (matcher.matches()) {
				dateFormat = TIMEFORMAT;
				formatter = "yyyy-MM-dd HH:mm:ss";
				// System.out.println("yyyy-MM-dd HH:mm:ss");
				return dateFormat;
			}

			// yyyy/MM/dd HH:mm:ss
			patter = Pattern.compile("^\\d{4}\\/\\d{1,2}\\/\\d{1,2}\\s{1}\\d{1,2}:\\d{1,2}:\\d{1,2}$"); // yyyy-MM-dd
																										// HH:mm:ss
			matcher = patter.matcher(value);
			if (matcher.matches()) {
				dateFormat = TIMEFORMAT2;
				formatter = "yyyy/MM/dd HH:mm:ss";
				// System.out.println("yyyy/MM/dd HH:mm:ss");
				return dateFormat;
			}

			if (!StringUtils.hasText(formatter)) {
				throw new IllegalArgumentException("cannot parse value[" + value + "] to date");
			}
		} catch (PatternSyntaxException se) {
			throw se;
		}

		return dateFormat;
	}

}
