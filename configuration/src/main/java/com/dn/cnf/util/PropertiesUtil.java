package com.dn.cnf.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 获取配置文件信息
 * 
 * @author allen
 *
 */
public class PropertiesUtil {
	/**
	 * 输出所有配置信息
	 * 
	 * @param props
	 */
	private static void printAllProperty(Properties props) {
		@SuppressWarnings("rawtypes")
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = props.getProperty(key);
			System.out.println(key + " : " + value);
		}
	}

	/**
	 * <pre>
	 * 根据key读取value
	 * 
	 * 第一种方式：
	 * 		根据文件名使用spring中的工具类进行解析filePath是相对路劲，
	 * 		文件需在classpath目录下比如：config.properties在包com.dn.cnf.config下，
	 * 		路径就是com/dn/cnf/config/ftp.properties
	 * </pre>
	 */
	public static String getProperties_1(String filePath, String keyWord) {
		Properties prop = null;
		String value = null;
		try {
			// 通过Spring中的PropertiesLoaderUtils工具类进行获取
			prop = PropertiesLoaderUtils.loadAllProperties(filePath);
			// 根据关键字查询相应的值
			value = prop.getProperty(keyWord);
			
			System.out.println("输出所有配置信息------------");
			printAllProperty(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * <pre>
	 * 根据key读取value
	 * 
	 * 第二种方式：
	 * 		使用缓冲输入流读取配置文件，然后将其加载，再按需操作绝对路径或相对路径， 
	 *		如果是相对路径，则从当前项目下的目录开始计算， 
	 *		如：当前项目路径/config/ftp.properties,相对路径就是config/ftp.properties
	 * </pre>
	 */
	public static String getProperties_2(String filePath, String keyWord) {
		Properties prop = new Properties();
		String value = null;
		try {
			// 通过输入缓冲流进行读取配置文件
			InputStream InputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));
			// 加载输入流
			prop.load(InputStream);
			// 根据关键字获取value值
			value = prop.getProperty(keyWord);
			
			System.out.println("输出所有配置信息------------");
			printAllProperty(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * <pre>
	 * 根据key读取value
	 * 
	 * 第三种方式： 
	 * 		相对路径，properties文件需在classpath目录下， 
	 * 		比如：config.properties在包com.dn.cnf.config下，路径就是/com/dn/cnf/config/ftp.properties
	 * </pre>
	 */
	public static String getProperties_3(String filePath, String keyWord) {
		Properties prop = new Properties();
		String value = null;
		try {
			InputStream inputStream = PropertiesUtil.class.getResourceAsStream(filePath);
			prop.load(inputStream);
			value = prop.getProperty(keyWord);
			
			System.out.println("输出所有配置信息------------");
			printAllProperty(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		// 注意路径问题
		String properties_1 = getProperties_1("com/dn/cnf/config/ftp.properties", "ftp.serverUrl");
		System.out.println("根据key读取value *** ftp.serverUrl = " + properties_1);
		System.out.println("*********************************************");
		
		// 注意路径问题
		String properties_2 = getProperties_2("src/main/resources/jdbc.properties", "c3p0.url");
		System.out.println("根据key读取value *** c3p0.url = " + properties_2);
		System.out.println("*********************************************");

		// 注意路径问题
		String properties_3 = getProperties_3("/com/dn/cnf/config/ftp.properties", "ftp.serverUrl");
		System.out.println("根据key读取value *** ftp.serverUrl = " + properties_3);
	}
}
