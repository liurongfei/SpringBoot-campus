package cn.edu.jxnu.rj.lrf.config.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

/**
 * @Classname RedisCache
 * @Description TODO 从redis中获取的认证或授权缓存
 * @Date 2021/5/14 20:28
 * @Created by 刘荣飞
 */
public class RedisCache<k,v> implements Cache<k,v> {
    @Override
    public v get(k k) throws CacheException {
        return null;
    }

    @Override
    public v put(k k, v v) throws CacheException {
        return null;
    }

    @Override
    public v remove(k k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<k> keys() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }
}
