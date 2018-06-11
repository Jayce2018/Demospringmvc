package com.peace.aop.service.Impl;

import com.peace.aop.service.Hello;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello world! I'm Aop_1_say.");
    }

    @Override
    public void doHello() {
        System.out.println("hello world! I'm Aop_do.");
    }
}
