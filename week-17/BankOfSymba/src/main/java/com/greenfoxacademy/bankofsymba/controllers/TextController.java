package com.greenfoxacademy.bankofsymba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {

    //@RequestMapping(path = "/enjoy", method = RequestMethod.GET)
    @GetMapping(value = "/enjoy")
    public String enjoyYourself(Model model) {
        model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "ception";
    }

    @GetMapping(value = "/enjoy2")
    @ResponseBody
    public String enjoyYourself() {
        return "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    }
}
