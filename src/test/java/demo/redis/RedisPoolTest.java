package demo.redis;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisPoolTest extends TestCase {
	public static void main(String[] args) {
		JedisPool pool = RedisPool.getPool();
		Jedis conn = pool.getResource();
		System.out.println(conn.get("test"));
		pool.returnBrokenResource(conn);
	}
}
