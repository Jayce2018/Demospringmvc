package com.peace.controller;

import com.github.pagehelper.PageHelper;
import com.peace.entity.NewUser;
import com.peace.entity.User;
import com.peace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //接收复杂JSON测试
    @RequestMapping(value = "/paramJson")
    @ResponseBody
    public String paramJson(@RequestParam String result){
        /*JSONArray arr = (JSONArray) JSONArray.parse(result);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).toString());
        }*/
        System.out.println("UserController====paramJson==============================================测试JSON！"+result);

        return "success";
    }

    //接收复杂JSON测试
    @RequestMapping(value = "/bodyJson")
    @ResponseBody
    public String bodyJson(@RequestBody NewUser[] result){
        /*JSONArray arr = (JSONArray) JSONArray.parse(result);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).toString());
        }*/
        System.out.println("UserController====bodyJson==============================================测试JSON！"+result);

        return "success";
    }

    //验证登录
    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam String userId, @RequestParam String passwords) {
        User user = new User();
        user.setId(userId);
        user.setPassword(passwords);
        int size = userService.selectByAdjust(user).size();

        return size > 0 ? 1 : 0;
    }


    //根据id获得用户信息
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUsers(@RequestParam String userId) {
        //调用service方法得到用户列表
        User users = userService.selectByPrimaryKey(userId);

        System.out.println("UserController==================================================成功查询用户！"+userId);
        return users;
    }

    //根据id修改用户密码
    @RequestMapping(value = "/updatePs",method = RequestMethod.GET)
    @ResponseBody
    public String getUsers(@RequestParam String userId,@RequestParam String ps) {
        //调用service方法
        User user=new User();
        user.setId(userId);
        user.setPassword(ps);
        int n = userService.updateByselective(user);
        System.out.println("返回值："+n);
        String str="str";
        if(n==0){
            str="修改失败，对象不存在！";

        }else{
            str="用户信息修改成功！";
            System.out.println("UserController==================================================修改用户信息！");
        }
        return str;
    }

    //查询所有用户信息
    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public List<User> selectAll() {
        //调用service方法
        return userService.selectAll();
    }

    //分页查询所有用户信息
    @RequestMapping(value = "/userList")
    @ResponseBody
    public List<User> userList(@RequestParam int n) {
        //调用service方法
        if(n<1) n=1;
        int pageSize=5;
        PageHelper.startPage(n,pageSize, true);

        List<User> users =userService.selectAll();

        System.out.println("usercontroller:"+users);
        return users;
    }

    //设置缓存用户信息
    @RequestMapping(value = "/sets")
    @ResponseBody
    public String userList(@RequestParam String id,String value) {
        //调用service方法
        return userService.sets(id,value);
    }

    //读取缓存用户信息
    @RequestMapping(value = "/gets")
    @ResponseBody
    public String userList(@RequestParam String id) {
        //调用service方法
        return userService.gets(id);
    }




}
