package com.peace.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.peace.service.RedisCache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.*;

@Repository
public class RedisCacheImpl implements RedisCache {
    @Resource(name = "redisCache")
    private RedisTemplate<String, String> cacheRedisTemplate;

    @Override
    public void put(Object key, Object value) {
        if(null == value) {
            return;
        }

        if(value instanceof String) {
            if(StringUtils.isEmpty(value.toString())) {
                return;
            }
        }

        // TODO Auto-generated method stub
        final String keyf = key + "";
        final Object valuef = value;
        final long liveTime = 86400;

        cacheRedisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                connection.set(keyb, valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public Object get(Object key) {
        final String keyf = (String) key;
        System.out.println("RedisImpl=================================="+keyf);
        Object object;
        object = cacheRedisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                byte[] key = keyf.getBytes();
                System.out.println("RedisImpl==1================================"+key);
                byte[] value = connection.get(key);

                System.out.println("RedisImpl==2================================"+toObject(value));
                if (value == null) {
                    return null;
                }
                return toObject(value);

            }
        });

        return null;
    }

    @Override
    public Object toObject(byte[] bytes){
        System.out.println("RedisImpl==3================================");
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            System.out.println("RedisImpl==4================================"+bis+"+++++"+ois);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    private Object byteArrayToObject(byte[] buffer) {
        Object ob = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
            ob = ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return ob;
    }

    @Override
    public byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
}
