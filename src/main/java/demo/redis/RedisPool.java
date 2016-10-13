package demo.redis;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池
 * 
 * @author 小磊子
 *
 */
public class RedisPool {
	private static Log log = LogFactory.getLog(RedisPool.class);
	private static JedisPool pool;

	public static final String CONFIG_FILE_NAME = "config";

	/**
	 * 初始化参数
	 */
	private static void init() {
		ResourceBundle res = ResourceBundle.getBundle(CONFIG_FILE_NAME);
		if (res == null) {
			if (log.isErrorEnabled()) {
				log.error("load file [" + CONFIG_FILE_NAME + "] failed");
			}
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.valueOf(res.getString("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(res.getString("redis.pool.maxIdle")));
		config.setMaxWait(Long.valueOf(res.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(res.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(res.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config, res.getString("redis.ip"), Integer.valueOf(res.getString("redis.port")));
	}

	/**
	 * 获取Redis连接池
	 */
	public static synchronized JedisPool getPool() {
		if (pool == null) {
			synchronized (RedisPool.class) {
				init();
			}
		}
		return pool;
	}
}
