package com.dn.apollo.api;

import com.google.common.base.Charsets;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleApolloConfigDemo {
	private static final Logger logger = LoggerFactory.getLogger(SimpleApolloConfigDemo.class);
	private String DEFAULT_VALUE = "undefined";
	private Config config;

	public SimpleApolloConfigDemo() {
		ConfigChangeListener changeListener = new ConfigChangeListener() {
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				logger.info("更改命名空间 {}", changeEvent.getNamespace());
				for (String key : changeEvent.changedKeys()) {
					ConfigChange change = changeEvent.getChange(key);
					logger.info("更改 - key: {}, oldValue: {}, newValue: {}, changeType: {}", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
				}
			}
			/**
			 * hreadpool = 100;
			 * 
			 */
		};
		config = ConfigService.getAppConfig();
		config.addChangeListener(changeListener);
	}

	private String getConfig(String key) {
		String result = config.getProperty(key, DEFAULT_VALUE);
		//logger.info(String.format("加载key : %s with value: %s", key, result));
		System.out.println(String.format("加载key : %s with value: %s", key, result));
		return result;
	}

	public static void main(String[] args) throws IOException {
		SimpleApolloConfigDemo apolloConfigDemo = new SimpleApolloConfigDemo();
		System.out.println("请输入键以获取值,输入quit退出。");
		while (true) {
			System.out.print("> ");
			String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
			if (input == null || input.length() == 0) {
				continue;
			}
			input = input.trim();
			if (input.equalsIgnoreCase("quit")) {
				System.exit(0);
			}
			apolloConfigDemo.getConfig(input);
		}
	}
}
