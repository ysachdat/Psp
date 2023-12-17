package com.automobilesales.controller;

import com.automobilesales.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatsCont extends Attributes {
    @GetMapping
    public String Statistics(Model model) {
        AddAttributesStats(model);
        return "stats";
    }
}
