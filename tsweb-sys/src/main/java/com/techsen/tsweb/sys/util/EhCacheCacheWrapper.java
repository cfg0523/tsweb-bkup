package com.techsen.tsweb.sys.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.ehcache.Element;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/**
 * EhCache的缓存包装类，
 * 实现了Shiro的缓存接口，以便Shiro可以使用EhCache缓存
 */
@SuppressWarnings("unchecked")
public class EhCacheCacheWrapper<K, V> implements Cache<K, V> {

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
        this.ehCacheCache.put(new Element(key, value));
        ;
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
        Set<V> values = new HashSet<V>();
        Map<Object, Element> eles = this.ehCacheCache.getAll(this.keys());
        for (Element ele : eles.values()) {
            values.add((V) ele.getObjectValue());
        }
        return values;
    }

    public net.sf.ehcache.Cache getEhCacheCache() {
        return this.ehCacheCache;
    }

    public void setEhCacheCache(net.sf.ehcache.Cache ehCacheCache) {
        this.ehCacheCache = ehCacheCache;
    }

}