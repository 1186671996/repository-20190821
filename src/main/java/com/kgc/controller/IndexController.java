package com.kgc.controller;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController
{
    @RequestMapping("/index")
    public String index()
    {
        System.out.println("");
        return "index";
    }
    
    @RequestMapping("/test3")
    public String index1(@RequestParam(value="num")int id)
    {
        System.out.println("age "+id);
//        System.out.println("num "+num);
        return "index2";
    }
}
