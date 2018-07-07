package com.peace.aop.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHandler {

    public void printTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss.mm-a");
        String date = sdf.format(new Date());
        System.out.println("==Aop:当前时间========================================:" + date);
    }

    public void orderSimplePrintTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss.mm-a");
        String date = sdf.format(new Date());
        System.out.println("==S定时器:当前时间========================================:" + date);
    }
}
