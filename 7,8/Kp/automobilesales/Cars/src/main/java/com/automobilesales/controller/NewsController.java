package com.automobilesales.controller;

import com.automobilesales.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class NewsController {

    @GetMapping("/news")
    public String showNewsPage() {
        return "news";
    }
}
