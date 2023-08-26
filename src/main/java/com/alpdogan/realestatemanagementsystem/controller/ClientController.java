package com.alpdogan.realestatemanagementsystem.controller;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody SaveClientRequestDto saveClientRequestDto) {
        return clientService.saveClient(saveClientRequestDto);
    }

    @GetMapping("/{clientId}")
    public Optional<Client> getClientById(@PathVariable int clientId) {
        return clientService.getClientById(clientId);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClientById(@PathVariable int clientId) {
        clientService.deleteClientById(clientId);
    }

}
