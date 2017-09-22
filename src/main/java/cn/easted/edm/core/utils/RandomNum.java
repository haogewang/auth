/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年9月1日 下午2:19:29   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年9月1日 下午2:19:29  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.utils;

import java.util.Random;

/**
 * @ClassName:D
 * @author:Wanghao
 * @date: 2017年9月1日 下午2:19:29
 */
public class RandomNum {

	private static char ch[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
			 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
			't', 'u', 'v', 'w', 'x', 'y', 'z','a','b','c','d','e','F', 'G','H', 'I', 'J', 'K', 'L', '+', '/' };//有重复，因为需要凑足数组长度为64


	private static Random random = new Random();
	//生成指定长度的随机字符串
	public static synchronized String createRandomString(int length) {
		if (length > 0) {
			int index = 0;
			char[] temp = new char[length];
			int num = random.nextInt();
			for (int i = 0; i < length % 5; i++) {
				temp[index++] = ch[num & 63];//取后面六位，记得对应的二进制是以补码形式存在的。
				num >>= 6;//63的二进制为:111111
			// 为什么要右移6位？因为数组里面一共有64个有效字符。为什么要除5取余？因为一个int型要用4个字节表示，也就是32位。
			}

			for (int i = 0; i < length / 5; i++) {
				num = random.nextInt();
				for (int j = 0; j < 5; j++) {
					temp[index++] = ch[num & 63];
					num >>= 6;
				}
			}
			return new String(temp, 0, length);

		}
		else if (length == 0) {
			return "";
		}
		else {
			throw new IllegalArgumentException();
		}

	}


	//根据指定个数，测试随机字符串函数的重复率

	public static double rateOfRepeat(int number) {
		int repeat = 0;
		String[] str = new String[number];
		for (int i = 0; i < number; i++) {//生成指定个数的字符串
			str[i] = RandomNum.createRandomString(10);
		}
		for (int i = 0; i < number; i++) {//查找是否有相同的字符串
			for (int j = i + 1; j < number - 1; j++) {
				if (str[i].equals(str[j]))
					repeat++;

			}
		}
		return ((double) repeat) / number;
	}


	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			System.out.println(RandomNum.createRandomString(164*2));
		}
		
//		double rate = RandomNum.rateOfRepeat(100000);//测试10000次的重复率
//		System.out.println("重复率:" + rate);

	}

}
