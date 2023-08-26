package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
import com.alpdogan.realestatemanagementsystem.repository.ClientRepository;
import com.alpdogan.realestatemanagementsystem.repository.RealEstateRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private RealEstateRepository realEstateRepository;

    public ClientService(ClientRepository clientRepository, RealEstateRepository realEstateRepository) {
        this.clientRepository = clientRepository;
        this.realEstateRepository = realEstateRepository;
    }

    public Client saveClient(SaveClientRequestDto saveClientRequestDto) {

        String firstNameRequest = saveClientRequestDto.getFirstName();
        String lastNameRequest = saveClientRequestDto.getLastName();
        Long phoneNumberRequest = saveClientRequestDto.getPhoneNumber();
        String emailAddressRequest = saveClientRequestDto.getEmailAddress();
//        int realEstateIdRequest = saveClientRequestDto.getRealEstateId();

//        RealEstate realEstate = realEstateRepository.findById(realEstateIdRequest).get();
        Client client = new Client();

        client.setFirstName(firstNameRequest);
        client.setLastName(lastNameRequest);
        client.setPhoneNumber(phoneNumberRequest);
        client.setEmailAddress(emailAddressRequest);
//        client.setRealEstates(Collections.singletonList(realEstate));

        return clientRepository.save(client);

    }

}
