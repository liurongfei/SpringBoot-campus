package cn.edu.jxnu.rj.lrf.security;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @Classname RedisCacheManager
 * @Description TODO redisCache管理器
 * @Date 2021/5/14 20:30
 * @Created by 刘荣飞
 */
public class RedisCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {

        return new RedisCache<>();
    }
}
