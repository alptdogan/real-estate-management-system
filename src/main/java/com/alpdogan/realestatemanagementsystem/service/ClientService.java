package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(SaveClientRequestDto saveClientRequestDto) {

        String firstNameRequest = saveClientRequestDto.getFirstName();
        String lastNameRequest = saveClientRequestDto.getLastName();
        Long phoneNumberRequest = saveClientRequestDto.getPhoneNumber();
        String emailAddressRequest = saveClientRequestDto.getEmailAddress();

        Client client = new Client();

        client.setFirstName(firstNameRequest);
        client.setLastName(lastNameRequest);
        client.setPhoneNumber(phoneNumberRequest);
        client.setEmailAddress(emailAddressRequest);

        return clientRepository.save(client);

    }

}
