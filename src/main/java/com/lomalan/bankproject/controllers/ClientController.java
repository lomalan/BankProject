package com.lomalan.bankproject.controllers;


import com.lomalan.bankproject.entities.Client;
import com.lomalan.bankproject.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 *     This class represented controller for Client.
 * </p>
 *
 * @author Anton Lomakin
 *
 * @since 1.0
 */

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.findAll());
        return "list-clients";
    }

    @PostMapping("/saveClient")
    public String addNewClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/showSaveClientForm")
    public String addClient(Model model){
        model.addAttribute("client", new Client());
        return "add-client";
    }
}
