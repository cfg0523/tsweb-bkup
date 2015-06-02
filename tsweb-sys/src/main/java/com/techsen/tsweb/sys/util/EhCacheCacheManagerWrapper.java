package com.techsen.tsweb.sys.util;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * EhCache缓存管理器CacheManager的包装类
 * 以便Shiro可以使用EhCache缓存
 */
public class EhCacheCacheManagerWrapper implements CacheManager {

    private net.sf.ehcache.CacheManager cacheManager;
    
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        net.sf.ehcache.Cache ehCacheCache = this.cacheManager.getCache(name);
        return new EhCacheCacheWrapper<K, V>(ehCacheCache);
    }
    
    public net.sf.ehcache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(net.sf.ehcache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

}
