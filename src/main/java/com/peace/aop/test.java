package com.peace.aop;

import com.peace.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class test {
    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ct.getBean("UserService");
        userService.selectAll();
    }
}