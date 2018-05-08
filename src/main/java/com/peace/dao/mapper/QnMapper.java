package com.peace.dao.mapper;

import com.peace.entity.unionQn;

import java.util.List;

public interface QnMapper {
    List<unionQn> findJg(Integer qnid);
}
