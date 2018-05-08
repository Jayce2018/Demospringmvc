package com.peace.service.impl;

import com.peace.dao.mapper.CustomersMapper;
import com.peace.entity.Customers;
import com.peace.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomersImpl implements CustomersService {
   @Autowired
    private CustomersMapper customersMapper;
    @Override
    public List<Customers> findAll() {

        return customersMapper.findAll();
    }
}
