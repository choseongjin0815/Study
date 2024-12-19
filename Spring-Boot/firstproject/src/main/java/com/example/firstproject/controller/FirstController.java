package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "조성진");
        return "greetings";
    }

    @GetMapping("bye")
    public String goodBye(Model model) {
        model.addAttribute("username", "테스트");
       return "goodbye";
    }

    @GetMapping("random")
    public String randomMsg(Model model) {
        String[] msg = {
                "a",
                "b",
                "c",
                "d",
                "e"
        };

        int randInt = (int)(Math.random() * msg.length);
        model.addAttribute("randommsg", msg[randInt]);
        return "randomtext";
    }
}
