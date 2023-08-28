package com.alpdogan.realestatemanagementsystem.controller;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.ClientResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("client") SaveClientRequestDto saveClientRequestDto) {

        clientService.saveClient(saveClientRequestDto);

        return "redirect:/clients";

    }
    @GetMapping("/new")
    public String displayClientForm (Model model) {

        SaveClientRequestDto saveClientRequestDto = new SaveClientRequestDto();
        model.addAttribute("client", saveClientRequestDto);

        return "client-add";

    }


    @GetMapping("/{clientId}")
    public Optional<Client> getClientById(@PathVariable int clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping
    public String getAllClients(Model model) {

        List<ClientResponseDto> clientResponseDtos = clientService.getAllClients();
        model.addAttribute("clients", clientResponseDtos);

        return "clients-list";
    }

    @DeleteMapping("/deleteClientById")
    public String deleteClientById(@RequestParam("clientId") int clientId) {

        clientService.deleteClientById(clientId);

        return "redirect:/clients";

    }

    @GetMapping("/details")
    public String displayClientDetails(@RequestParam("clientId") int clientId, Model model) {

        Optional<Client> client = clientService.getClientById(clientId);
        model.addAttribute("client", client);

        return "client-details";

    }

}
