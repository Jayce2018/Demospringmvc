package com.peace.controller;

import com.peace.entity.Customers;
import com.peace.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/cs")
public class CsController {
    @Autowired
    private CustomersService customersService;
    //查询所有用户信息
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Customers> selectAll() {
        //调用service方法
        return customersService.findAll();
    }
}
