package com.peace.controller;

import com.peace.util.JedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cache")
public class RedisCacheController {

    JedisUtil jt=new JedisUtil();

    @RequestMapping(value = "set", method = RequestMethod.GET)
    @ResponseBody
    public String setValue(@RequestParam String key,String value) {
        return jt.setValue(key, value);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public String getValue(@RequestParam String key) {
        return jt.getValue(key);
    }

    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getList(@RequestParam String key) {
        return jt.getList(key);
    }


}
