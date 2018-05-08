package com.peace.service;

import com.peace.entity.User;

import java.util.List;

public interface UserService {
   User selectByPrimaryKey(String Userid);
   int updateByselective(User user);
   List<User> selectAll();
   List<User> userList(int n);
}
