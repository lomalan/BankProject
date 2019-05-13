package com.lomalan.bankproject.controllers;

import com.lomalan.bankproject.entities.dto.AccountDto;
import com.lomalan.bankproject.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *     This class represented controller for Account.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/list")
    public String getAccounts(@RequestParam("clientId") Long id,  Model model){
        model.addAttribute("accounts", accountService.findAllAccountsByClient(id));

        return "list-accounts";
    }


    @PostMapping("/saveAccount")
    public String addNewAccount(@ModelAttribute("account") AccountDto account, @RequestParam("clientId") Long id){
        accountService.saveAccount(account, id);
        return "redirect:/";
    }

    @GetMapping("/showSaveAccountForm")
    public String addAccount(Model model){
        model.addAttribute("account", new AccountDto());
        return "add-account";
    }
}
