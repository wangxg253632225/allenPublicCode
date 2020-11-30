package com.dongnaoedu.poling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 配置类开启Redis Http Session
 * maxInactiveIntervalInSeconds设置session超时时间,默认1800秒
 * 
 * @author allen
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

}
