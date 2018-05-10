package com.peace.service;

public interface RedisCache {

    void put(Object key, Object value);

    Object get(Object key);

    Object toObject(byte[] bytes);

    byte[] toByteArray(Object obj);
}
