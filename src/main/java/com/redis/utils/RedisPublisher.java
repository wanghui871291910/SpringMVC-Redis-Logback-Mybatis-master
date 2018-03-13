package com.redis.utils;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * publish message to redis channel
 * @author spirit_only
 *
 */
public class RedisPublisher {
	private RedisTemplate<String, Object> redisTemplate = null;
	
	public RedisPublisher(){
		
	}
	
	/**
	 * send msg to redis channel
	 * @param channel redis channal name
	 * @param message serializable msg
	 */
	public void sendMessage(String channel, Serializable message){
		getRedisTemplate().convertAndSend(channel, message);
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
