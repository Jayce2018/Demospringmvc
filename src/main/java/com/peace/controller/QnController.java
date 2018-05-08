package com.peace.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.peace.entity.unionQn;
import com.peace.service.QnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("qn")
public class QnController {
    @Autowired
    private QnService qnService;
    @RequestMapping("/findJg")
    @ResponseBody
    public List<unionQn> findJg(@RequestParam String qnid){
        List<unionQn> list=new ArrayList<>();
        Integer strid=Integer.parseInt(qnid);
        list=qnService.selectQn(strid);
        return list;
    }

    @RequestMapping("/findJs")
    @ResponseBody
    public String findJs(@RequestParam String qnid){
        Integer strid=Integer.parseInt(qnid);
        List<unionQn> list=qnService.selectQn(strid);
        String str= JSON.toJSONString(list);

        JSONArray rsar=JSON.parseArray(str);

        //解析结果
        List<unionQn> rs=new ArrayList<>();

        for(unionQn ob:list){
            unionQn tmp=new unionQn();
            tmp.setQnid(ob.getQnid());
            tmp.setOpcontent(ob.getOpcontent());
            tmp.setOporderid(ob.getOporderid());
            tmp.setOptionid(ob.getOptionid());
            tmp.setQnname(ob.getQnname());
            tmp.setTocontent(ob.getTocontent());
            tmp.setToorderid(ob.getToorderid());
            tmp.setTopicid(ob.getTopicid());
            rs.add(tmp);
        }
        if(str.length()>2){//json字符串为空时，有一个方括号占2个字符
            System.out.println("QnController========================================问卷名：");
            return str;
        }else{
            return "对象不存在";
        }
    }
}
