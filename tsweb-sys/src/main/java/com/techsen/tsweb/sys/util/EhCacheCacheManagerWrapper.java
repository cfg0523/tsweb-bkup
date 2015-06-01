package com.techsen.tsweb.sys.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.sf.ehcache.Element;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

@SuppressWarnings("unchecked")
public class EhCacheCacheManagerWrapper implements CacheManager {

    private net.sf.ehcache.CacheManager cacheManager;
    
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        net.sf.ehcache.Cache ehCacheCache = this.cacheManager.getCache(name);
        return new EhCacheCacheWrapper<K, V>(ehCacheCache);
    }
    
    public static class EhCacheCacheWrapper<K, V> implements Cache<K, V> {

        private net.sf.ehcache.Cache ehCacheCache;
        
        public EhCacheCacheWrapper(net.sf.ehcache.Cache ehCacheCache) {
            this.ehCacheCache = ehCacheCache;
        }
        
        @Override
        public V get(K key) throws CacheException {
            return (V) this.ehCacheCache.get(key).getObjectValue();
        }

        @Override
        public V put(K key, V value) throws CacheException {
            this.ehCacheCache.put(new Element(key, value));;
            return value;
        }

        @Override
        public V remove(K key) throws CacheException {
            this.ehCacheCache.remove(key);
            return null;
        }

        @Override
        public void clear() throws CacheException {
            this.ehCacheCache.removeAll();
        }

        @Override
        public int size() {
            return this.ehCacheCache.getSize();
        }

        @Override
        public Set<K> keys() {
            return new HashSet<K>(this.ehCacheCache.getKeys());
        }

        @Override
        public Collection<V> values() {
            return null;
        }

        public net.sf.ehcache.Cache getEhCacheCache() {
            return ehCacheCache;
        }

        public void setEhCacheCache(net.sf.ehcache.Cache ehCacheCache) {
            this.ehCacheCache = ehCacheCache;
        }
        
    }
    
    public net.sf.ehcache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(net.sf.ehcache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

}
