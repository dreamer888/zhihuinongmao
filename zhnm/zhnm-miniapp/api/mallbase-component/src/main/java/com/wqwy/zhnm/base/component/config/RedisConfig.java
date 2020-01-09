
package com.wqwy.zhnm.base.component.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 
 * @ClassName: RedisConfig  
 * @Description: 测试阶段  
 * @author seven  
 * @date 7 Jun 2018 11:21:42 AM  
 *
 */
@Configuration
@ConditionalOnProperty(name = "redis.enabled", havingValue = "true")
public class RedisConfig {

	private final ComponentProperties componentProperties;
	
	public RedisConfig(ComponentProperties componentProperties) {
		this.componentProperties = componentProperties;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(componentProperties.getRedis().getHostname());
		redisStandaloneConfiguration.setPort(componentProperties.getRedis().getPort());
		redisStandaloneConfiguration.setDatabase(componentProperties.getRedis().getDatabase());
		redisStandaloneConfiguration.setPassword(RedisPassword.of(componentProperties.getRedis().getPassword()));
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setDefaultSerializer(new StringRedisSerializer());
		return template;
	}

}
