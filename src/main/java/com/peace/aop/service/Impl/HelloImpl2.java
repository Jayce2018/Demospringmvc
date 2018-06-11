package com.peace.aop.service.Impl;

import com.peace.aop.service.Hello;

public class HelloImpl2 implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello world! I'm Aop_2_say.");
    }

    @Override
    public void doHello() {
        System.out.println("Hello world! I'm Aop_2_do.");
    }
}
