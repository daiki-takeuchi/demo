package com.example.web;

import com.example.domain.Hello;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    @RequestMapping("/hello")
    public Model hello(Model model) {
        Hello data = new Hello("Taro","taro@yamada","090-999-999");
        model.addAttribute("data",data);
        model.addAttribute("msg","これはThymeleafを使ったサンプルです。");
        return model;
    }
    
}