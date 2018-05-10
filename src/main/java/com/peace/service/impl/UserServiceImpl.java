package com.peace.service.impl;

import com.peace.dao.mapper.UserMapper;
import com.peace.entity.User;
import com.peace.service.UserService;
import com.peace.util.RedisTem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;

    //@Resource(name = "redisCache")
    //private RedisTemplate<String, String> cacheRedisTemplate;

    @Autowired
    private RedisTem redisTem;

    @Override
    public User selectByPrimaryKey(String userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByselective(User user) {
        int n=userMapper.updateByPrimaryKeySelective(user);
        return n;
    }

    @Override
    public List<User> selectAll() {
        //cacheRedisTemplate.opsForList().leftPush("list","a");
        //cacheRedisTemplate.opsForList().leftPush("list","b");
        //System.out.println("UserServiceImpl================================"+cacheRedisTemplate.opsForList().leftPop("list"));
        return  userMapper.selectAll();
    }

    @Override
    public List<User> userList(int n) {
        return userMapper.userList(n);
    }



    @Override
    public String gets(String id) {
        System.out.println("UserServiceImpl==1=============================="+id);
        return  redisTem.gets(id);
    }

    @Override
    public String sets(String id,String value){
        try {
            System.out.println("UserServiceImpl==2=============================="+id+":"+value);
            redisTem.sets(id, value);
            return "设置成功";
        }catch (Exception e){
            return "设置失败";
        }
    }
}
