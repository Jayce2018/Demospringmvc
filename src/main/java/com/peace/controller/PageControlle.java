package com.peace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "page")
public class PageControlle {
        @RequestMapping("/test")
        public String path(ModelMap modelMap) {
            return "test";
        }
    }

