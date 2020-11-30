package com.dn.cnf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供一个系统配置的属性加载器. 通过一个线程跟踪属性文件的修改，实现修改完成后的热加载. 使用方法：String myProperty =
 * ConfigPropertyUtil.getInstance().getProperty("myPropertyKey");
 */
public class ConfigPropertyUtil implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private static ConfigPropertyUtil instance; // 配置实例

	private final static String propertiesFile = "ftp.properties";// 配置文件名

	private static Properties configInfoProps = null; // 配置属性

	private static long propertyModLasttime; // 属性文件最后修改时间

	private File configrationFile; // 属性文件

	/** 构造方法：使用一个单例用来获取唯一实例 */
	private ConfigPropertyUtil(File configrationFile) {
		this.configrationFile = configrationFile;
	}

	public static Properties getConfigInfoProps() {
		return configInfoProps;
	}

	/**
	 * 初始化配置实例.
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	public static synchronized ConfigPropertyUtil initialize(String proFile) throws RuntimeException {
		if (instance != null) {
			throw new RuntimeException("配置属性只能初始化一次！");
		}
		File file = null;
		if (!StringUtils.isEmpty(proFile)) {
			file = new File(proFile);
		} else {
			ClassLoader loader = ConfigPropertyUtil.class.getClassLoader();
			file = new File(loader.getResource(propertiesFile).getFile());
		}
		instance = new ConfigPropertyUtil(file);
		instance.setProperty();
		instance.new ConfigrationListener().start();
		return instance;
	}

	/**
	 * 返回配置实例
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	public static synchronized ConfigPropertyUtil getInstance() throws RuntimeException {
		if (instance == null) {
			initialize(null);
		}
		return instance;
	}

	/**
	 * 根据属性文件路径实例化
	 * 
	 * @param propertiesFile
	 *            属性文件路径
	 * @return
	 * @throws RuntimeException
	 */
	public static synchronized ConfigPropertyUtil getInstance(String proFile) throws RuntimeException {
		if (instance == null) {
			initialize(proFile);
		}
		return instance;
	}

	/**
	 * 获取属性
	 * 
	 * @param name
	 * @return
	 */
	public static String getProperty(String name) {
		String retrunValue = "";
		retrunValue = (String) configInfoProps.getProperty(name);
		return retrunValue;
	}

	/**
	 * 设置属性
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	private void setProperty() {
		Properties pro = new Properties();

		try {
			FileInputStream inputStream = new FileInputStream(configrationFile);
			pro.load(inputStream);
			instance.configInfoProps = pro;
			propertyModLasttime = configrationFile.lastModified();
		} catch (IOException e) {
			System.out.println("设置配置文件出错：" + e.getMessage());
		}
	}

	/**
	 * 配置线程监听器.
	 * <p>
	 * 用来监听配置文件是否修改，如果修改则重新载入.
	 * <p>
	 */
	class ConfigrationListener extends Thread {
		public ConfigrationListener() {
			super("属性文件跟踪器已启动...");
			//setDaemon(true);
		}

		public void run() {
			long sleepTime = 10 * 1000; // 扫描间隔时间
			while (true) {
				try {
					Thread.sleep(sleepTime);
					if (configrationFile.lastModified() > propertyModLasttime) {
						setProperty();
						System.out.println(configrationFile.getName() + " 已更改，重新载入...");
					}
				} catch (Throwable throwable) {
					System.out.println("线程跟踪器错误：" + throwable);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String f = ConfigPropertyUtil.getInstance().getProperty("ftp.hostName");
		System.out.println(f);
	}

}