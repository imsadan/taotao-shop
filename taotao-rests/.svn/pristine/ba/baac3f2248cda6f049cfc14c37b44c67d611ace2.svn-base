package csc.test;

import redis.clients.jedis.Jedis;

public class jedisTest {
    public static void main(String[] args) {
		Jedis jedis=new Jedis("192.168.109.128",6379);
		jedis.set("fk_shit","123456");
		String result=jedis.get("fk_shit");
		System.out.println(result);
		//关闭
		jedis.close();
		
	}
}
