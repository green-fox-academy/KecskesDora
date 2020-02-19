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

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", bankAccounts);
        return "table";
    }

    @PostMapping("/accounts")
    //public String raiseBalance(@RequestParam("select-name") String selected) {
    public String raiseBalance(@ModelAttribute("select-name") String selectedName) {
        raise(selectedName);
        return "redirect:/accounts";
    }

    @PostMapping("/raise-balance")
    public String raiseBalanceByButton(@ModelAttribute("raise-balance") String selectedName) {
        raise(selectedName);
        return "redirect:/accounts";
    }

    @GetMapping("/add")
    public String addNewAccountForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute(name = "account") BankAccount account) {
        bankAccounts.add(account);
        return "redirect:/accounts";
    }

    @GetMapping("/add2")
    public String addNewAccountForm2(Model model, @ModelAttribute("account") BankAccount account) {
        model.addAttribute("account", account);
        return "add2";
    }

    @PostMapping("/add2")
    public String addAccount2(Model model, @ModelAttribute("account") BankAccount account) {
        bankAccounts.add(account);
        return "redirect:/accounts";
    }

    public void raise(String name) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getName().equals(name)) {
                if (bankAccount.getIsKing()) {
                    bankAccount.setBalance(bankAccount.getBalance() + 100);
                } else {
                    bankAccount.setBalance(bankAccount.getBalance() + 10);
                }
            }
        }
    }
}

