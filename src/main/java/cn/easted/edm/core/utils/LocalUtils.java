package cn.easted.edm.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LocalUtils {
	/**
	 * 将时间格式字符串转换为时间类型
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @author yiny
	 */
	public static Date dateParse(String dateString, String pattern) {
		if (dateString != null && pattern != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date date = null;
			try {
				date = sdf.parse(dateString);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			return date;
		}
		return new Date();

	}

	/**
	 * 判断String或List是否为null或者为空
	 * 
	 * @param str
	 *            对象
	 * @return true:对象为null或空 false:对象不为空
	 */
	public static boolean nullOrEmpty(Object str) {
		if (str == null)
			return true;
		if (str instanceof String) {
			if (((String) str).trim().equals(""))
				return true;
		}
		if (str instanceof List<?>) {
			if (((List<?>) str).size() == 0)
				return true;
		}

		return false;
	}

	/**
	 * 将一个以逗号分隔的ID列表转换成List<String> 注意：idList不要太长，否则会效率很低
	 * 
	 * @param idList
	 *            ID列表如："1|2|3|6|9|10"
	 * @return 转换后的List对象
	 */
	public static List<Long> idsToList(String idList) {
		if (idList == null)
			return null;
		idList = idList.replace(" ", "");
		while (idList.indexOf("||") != -1) {
			idList = idList.replace("||", "|");
		}
		if (idList.startsWith("|"))
			idList = idList.substring(1);
		if (idList.endsWith("|"))
			idList = idList.substring(0, idList.length() - 1);
		if (idList.trim().equals(""))
			return null;
		String[] strArr = idList.split("\\|");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < strArr.length; i++) {
			Long lId = null;
			try {
				lId = Long.parseLong(strArr[i]);
			} catch (NumberFormatException e) {
				lId = null;
			}
			if (lId == null)
				continue;
			list.add(lId);
		}
		if (list.size() == 0)
			return null;
		return list;
		// Long[]
		// arr=(Long[])ConvertUtils.convert((idList).split(","),Long.class);
		// return Arrays.asList(arr);
		// 坑爹货，Java 8用以下方法：
		// List<Long> list = Arrays.asList(idList.split(",")).stream().map(s ->
		// Long.parseLong(s.trim())).collect(Collectors.toList());
	}

	/**
	 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
	 * 
	 * @param strSrc
	 *            要加密的字符串
	 * @param encName
	 *            加密类型
	 * @return
	 */
	public static String StrEncrypt(String strSrc, String encName) {
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			if (encName == null || encName.equals("")) {
				encName = "SHA-256";
			}
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		return strDes;
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static String beanToField(String beanStr) {
		return beanStr.replaceAll("([A-Z])", "_$1");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(LocalUtils.idsToList("||1|2|||5| 7|9|").size());

//		System.out.println(LocalUtils.beanToField("UosNameUUser"));
		String str = getRandomString(10);
		System.out.println(str);
	}
	
	public static char getRandomChar(){  
        String str = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";  
        Random r = new Random();  
        char ch = str.charAt(r.nextInt(36));  
        return ch;  
    }  
    public static String getRandomString(int length){  
        StringBuffer str = new StringBuffer();  
        while(length > 0){  
            char ch = getRandomChar();  
            str.append(ch);  
            length--;  
        }  
        return str.toString();  
    }  
    
  
//    public static void main(String[] args) {  
//        String str = getRandomString(10);  
//        System.out.print(str);  
//    }  

}
