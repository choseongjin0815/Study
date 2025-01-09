package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafTestController {
    @GetMapping("/test")
    public String hello(Model model){
        List<String> arrList = new ArrayList<String>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("d");
        arrList.add("e");
        arrList.add("f");
        model.addAttribute("msg", arrList);

        return "thymeleaf/test";
    }

}
