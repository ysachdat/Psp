package com.automobilesales.controller;

import com.automobilesales.controller.main.Attributes;
import com.automobilesales.model.enums.BodyType;
import com.automobilesales.model.enums.Fuel;
import com.automobilesales.model.enums.Transmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexCont extends Attributes {

    @GetMapping
    public String index1(Model model) {
        AddAttributesIndex(model);
        return "index";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        AddAttributesIndex(model);
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam BodyType bodyType, @RequestParam Transmission transmission) {
        AddAttributesIndexSearch(model, bodyType, transmission);
        return "index";
    }
}
