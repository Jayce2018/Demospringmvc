package com.peace.util;

import com.peace.common.RedisCofig;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisUtil {
    //连接本地的 Redis 服务
    String hoststr=RedisCofig.hostid;

    public Jedis getJedis() {
        return jedis;
    }

    Jedis jedis = new Jedis(hoststr);

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public  String setValue(String id,String value){
        jedis.set(id,value);
        return "设置成功";
    }
    public String getValue(String id){
        return jedis.get(id);
    }

    public List<String> getList(String id){

        return jedis.lrange(id,0,10);
    }


}
