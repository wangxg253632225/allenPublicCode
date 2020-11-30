package com.dongnaoedu.poling.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration  
@ConditionalOnClass(RedisOperations.class)  
@EnableConfigurationProperties(RedisProperties.class)  
public class RedisConfig {  
  
	@Bean
    public RedisTemplate<Object, Object> redisTemplate(  
            RedisConnectionFactory redisConnectionFactory) {  
        RedisTemplate<Object, Object> template = new RedisTemplate<>();  
  
        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        
        //使用fastjson序列化  
        //FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);  
        
        // value值的序列化采用fastJsonRedisSerializer  
        template.setValueSerializer(jackson2JsonRedisSerializer);  
        template.setHashValueSerializer(jackson2JsonRedisSerializer);  
        // key的序列化采用StringRedisSerializer  
        template.setKeySerializer(new StringRedisSerializer());  
        template.setHashKeySerializer(new StringRedisSerializer());  
  
        template.setConnectionFactory(redisConnectionFactory);  
        return template;  
    }  
  
    @Bean  
    public StringRedisTemplate stringRedisTemplate(  
            RedisConnectionFactory redisConnectionFactory) {  
        StringRedisTemplate template = new StringRedisTemplate();  
        template.setConnectionFactory(redisConnectionFactory);  
        return template;  
    }  
  
}  