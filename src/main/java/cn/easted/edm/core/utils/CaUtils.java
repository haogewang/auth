/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年3月20日 上午11:33:57   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: lei
 * @Date: 2017年3月20日 上午11:33:57
 */
public class CaUtils {
	public static String getCa(String ipAddr) {
		if (!ipAddr.contains("http://")) {
			ipAddr = "http://" + ipAddr;
		}
		if (!ipAddr.contains("/ca.crt")) {
			ipAddr = ipAddr + "/ca.crt";
		}
		StringBuffer sbString = new StringBuffer();
		URL url = null;
		try {
			url = new URL(ipAddr);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			String buf = null;
			while ((buf = reader.readLine()) != null) {
				sbString.append(buf + "\\n");// System.getProperty("line.separator")错误
			}
			reader.close();
			inStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sbString.toString();

	}

	public static void main(String args[]) {

		System.out.println(getCa("http://10.10.139.12/ca.crt"));
	}

}
