package com.peace.test;

import redis.clients.jedis.Jedis;
import com.peace.common.RedisCofig;

public class Test {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        String hoststr=RedisCofig.hostid;
        Jedis jedis = new Jedis(hoststr);
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");

        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("type"));
    }
}
