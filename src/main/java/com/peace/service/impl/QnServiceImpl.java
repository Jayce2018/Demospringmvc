package com.peace.service.impl;

import com.peace.dao.mapper.QnMapper;
import com.peace.entity.unionQn;
import com.peace.service.QnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QnServiceImpl implements QnService{
    @Autowired
    private QnMapper qnMapper;

    @Override
    public List<unionQn> selectQn(Integer qnid) {
        return  qnMapper.findJg(qnid);
    }
}

