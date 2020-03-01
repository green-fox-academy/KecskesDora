package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Drink;
import com.greenfoxacademy.programmerfoxclub.models.Food;
import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

    FoxService foxService;

    @Autowired
    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(Model model, @RequestParam(value = "name", required = true) String name) {
        model.addAttribute("name", name);
        model.addAttribute("drinks", Drink.getList());
        model.addAttribute("foodList", Food.getList());
        return "nutrition-store";
    }

    @PostMapping("/nutritionStore")
    public String nutritionStore(@RequestParam(value = "name", required = true) String name, String food, String drink) {
        foxService.changeAndTrackFood(food, name);
        foxService.changeAndTrackDrink(drink, name);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String trickCenter(Model model, @RequestParam(value = "name", required = true) String name) {
        model.addAttribute("fox", foxService.find(name));
        //model.addAttribute("tricks", foxService.tricksToLearn(name));
        return "trick-center";
    }

    @PostMapping("/trickCenter")
    public String trickCenter(@RequestParam(value = "name", required = true) String name, String trick) {
        foxService.addAndTrackNewTrick(trick, name);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/actionHistory")
    public String actionHistory(Model model, @RequestParam(value = "name", required = true) String name) {
        model.addAttribute("fox", foxService.find(name));
        return "action-history";
    }
}
