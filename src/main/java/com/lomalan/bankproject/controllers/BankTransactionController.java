package com.lomalan.bankproject.controllers;

import com.lomalan.bankproject.entities.dto.Period;
import com.lomalan.bankproject.entities.Account;
import com.lomalan.bankproject.entities.BankTransaction;
import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.services.interfaces.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/**
 * <p>
 *     This class represented controller for BankTransaction.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Controller
@RequestMapping("/transact")
public class BankTransactionController {

    private BankTransactionService bankTransactionService;
    private static final String REDIRECT_TO_HOME_PAGE = "redirect:/";
    private static final String LIST_TRANSACTION_PAGE = "list-transactions";
    private static final String TRANSACTION_VARIABLE = "transactions";

    @Autowired
    public void setBankTransactionService(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }


    @GetMapping("/list/period")
    public String getAllTransactionsByPeriod(Model model,@ModelAttribute("period") Period period ){
        model.addAttribute(TRANSACTION_VARIABLE, bankTransactionService
                .findAllTransactionByPeriod(LocalDateTime.parse(period.getFrom()), LocalDateTime.parse(period.getTo())));
        clearModelAttributes(model);
        return LIST_TRANSACTION_PAGE;
    }
    @GetMapping("/list/client")
    public String getAllTransactionsByClient(@ModelAttribute("client") Client client, Model model){
        model.addAttribute(TRANSACTION_VARIABLE, bankTransactionService.findTransactionByClient(client));
        clearModelAttributes(model);
        return LIST_TRANSACTION_PAGE;
    }

    @GetMapping("/list")
    public String getAllTransactions(Model model){
        model.addAttribute(TRANSACTION_VARIABLE, bankTransactionService.findAllTransactions());
        clearModelAttributes(model);
        return LIST_TRANSACTION_PAGE;
    }

    @PostMapping("/saveTransaction")
    public String addNewTransaction(@ModelAttribute("bankTransaction") BankTransaction bankTransaction,
                                    @RequestParam("senderId") Long id){
        Account account = new Account();
        account.setId(id);
        bankTransaction.setAccountSender(account);
        bankTransactionService.saveTransaction(bankTransaction);
        return REDIRECT_TO_HOME_PAGE;
    }

    @PostMapping("/saveReplenishment")
    public String addNewReplenish(@ModelAttribute("bankTransaction") BankTransaction bankTransaction,
            @RequestParam("receiverId") Long id){
        Account account = new Account();
        account.setId(id);
        bankTransaction.setAccountReceiver(account);
        bankTransactionService.saveTransaction(bankTransaction);
        return REDIRECT_TO_HOME_PAGE;
    }

    @GetMapping("/showAddTransactionForm")
    public String addTransaction(Model model){
        addModelAttribute(model);
        return "add-transaction";
    }

    @GetMapping("/showReplenishForm")
    public String addReplenishTransaction(Model model){
        addModelAttribute(model);
        return "add-replenish";
    }

    @GetMapping("/showWithdrawForm")
    public String addWithdrawTransaction(Model model){
        addModelAttribute(model);
        return "add-withdraw";
    }

    private void addModelAttribute(Model model){

        model.addAttribute("bankTransaction", new BankTransaction());
    }

    private void clearModelAttributes(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("period", new Period());
    }
}
