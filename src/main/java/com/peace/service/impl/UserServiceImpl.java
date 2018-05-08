package com.peace.service.impl;

import com.peace.dao.mapper.UserMapper;
import com.peace.entity.User;
import com.peace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper user) {
        this.userMapper = user;
    }

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
        return  userMapper.selectAll();
    }

    @Override
    public List<User> userList(int n) {
        return userMapper.userList(n);
    }
}
