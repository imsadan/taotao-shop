package csc.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//使用连接池
public class jedisPool {
    public static void main(String[] args) {
		JedisPool jedisPool=new JedisPool("192.168.109.128",6379);
		Jedis jedis=jedisPool.getResource();
		System.out.println(jedis.get("test"));
		jedis.close();
		jedisPool.close();
	}
}
