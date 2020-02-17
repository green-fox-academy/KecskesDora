package com.greenfoxacademy.bankofsymba.controllers;

import com.greenfoxacademy.bankofsymba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/show/{name}")
    public String showAccount(Model model, @PathVariable(name = "name") String name) {
        BankAccount account = null;

        for(BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getName().equals(name)) {
                account = bankAccount;
            }
        }

        if (account != null) {
            model.addAttribute("account", account);
        } else {
            model.addAttribute("error", "No account found");
        }

        return "index";
    }

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

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", bankAccounts);
        return "table";
    }

    @PostMapping("/accounts")
    public String raiseBalance(@ModelAttribute(value = "select-name") String selected) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getName().equals(selected)) {
                if (bankAccount.isKing()) {
                    bankAccount.setBalance(bankAccount.getBalance() + 100);
                } else {
                    bankAccount.setBalance(bankAccount.getBalance() + 10);
                }
            }
        }
        return "redirect:/accounts";
    }

    @GetMapping("/add")
    public String addNewAccountForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addAccount(BankAccount account) {
        bankAccounts.add(account);
        return "redirect:/accounts";
    }

    @PostMapping("/add2")
    public String addAccount2(@ModelAttribute (value = "name") String name,
                              @ModelAttribute (value = "balance") int balance,
                              @ModelAttribute (value = "animalType") String animalType,
                              @ModelAttribute (value = "isKing") boolean isKing,
                              @ModelAttribute (value = "isGood") boolean isGood) {

        bankAccounts.add(new BankAccount(name, balance, animalType, isKing, isGood));
        return "redirect:/accounts";
    }
}

