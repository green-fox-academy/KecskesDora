package com.greenfoxacademy.bankofsymba.controllers;

import com.greenfoxacademy.bankofsymba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankController {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankController() {
        bankAccounts.add(new BankAccount("Simba", 2000, "lion", true, true));
        bankAccounts.add(new BankAccount("Timon", 1000, "meerkat",false, true));
        bankAccounts.add(new BankAccount("Pumbaa", 1100, "warthog", false, true));
        bankAccounts.add(new BankAccount("Zordon", 1500, "lion", false, false));
        bankAccounts.add(new BankAccount("Ed", 800, "hyena", false, false));
        bankAccounts.add(new BankAccount("Banzai", 900, "hyena", false, false));
    }

    //@RequestMapping(path = "/show", method = RequestMethod.GET)
    @GetMapping(value = "/show")
    public String showAccount(Model model) {
        model.addAttribute("account", bankAccounts.get(0));
        return "index";
    }

    //@RequestMapping(path = "/enjoy", method = RequestMethod.GET)
    @GetMapping(value = "/enjoy")
    public String enjoyYourself(Model model) {
        model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "utext-example";
    }

    @GetMapping(value = "/enjoy2")
    @ResponseBody
    public String enjoyYourself() {
        return "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    }

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", bankAccounts);
        return "table";
    }
}

