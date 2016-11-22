package com.example.web;

import com.example.domain.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(method= RequestMethod.GET)
    public Model get(Model model) {
        logger.info("HelloController#get");
        Hello data = new Hello("Taro","taro@yamada","090-999-999");
        model.addAttribute("data",data);
        model.addAttribute("msg","これはThymeleafを使ったサンプルです。");
        return model;
    }
}