package com.example.y.mvp.utils;

import java.util.HashMap;

/**
 * by 12406 on 2016/7/16.
 */
public class CacheUitls {

    public HashMap<String, Object> hashMap = new HashMap<>();

    private CacheUitls() {
    }

    public static CacheUitls getInstance() {
        return CacheHolder.CACHE_UITLS;
    }

    public void put(String key, Object value) {
        hashMap.put(key, value);
    }

    public <T> T get(String key) {
        return (T) hashMap.get(key);
    }

    public void remove(String key) {
        hashMap.remove(key);
    }

    private static class CacheHolder {
        public static final CacheUitls CACHE_UITLS = new CacheUitls();
    }
}
