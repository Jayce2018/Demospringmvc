package com.peace.service;

import com.peace.entity.unionQn;

import java.util.List;

public interface QnService {
    List<unionQn> selectQn(Integer qid);
}
