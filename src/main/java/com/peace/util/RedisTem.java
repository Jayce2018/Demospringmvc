package com.peace.util;

import com.peace.common.RedisCofig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;



@Repository
public class RedisTem {

    @Resource(name = "redisCache")
    private RedisTemplate<String, String> cacheRedisTemplate;

    public void setRedisCache(RedisTemplate<String, String> redisCache) {
        this.cacheRedisTemplate = redisCache;
    }

    //获取字符型缓存值
    public String gets(String id) {
        System.out.println("RedisUtil==1=============================="+id);
        return  cacheRedisTemplate.opsForValue().get(id);
    }

    //设置字符型缓存
    public String sets(String id,String value){
            System.out.println("RedisUtil==2=============================="+id+":"+value);
            cacheRedisTemplate.opsForValue().set(id, value);
            return "设置成功";
    }
}
