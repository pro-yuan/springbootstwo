package com.offcn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class javaController {
    @RequestMapping("/hello")
    public Map sayHello(){
        Map map = new HashMap();
        map.put("java","我爱java");
        return map;
    }
}

