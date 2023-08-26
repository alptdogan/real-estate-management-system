package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.ClientResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.repository.ClientRepository;
import com.alpdogan.realestatemanagementsystem.repository.RealEstateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    //update eklenebilir.

    private ClientRepository clientRepository;
    private RealEstateRepository realEstateRepository;
    private ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, RealEstateRepository realEstateRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.realEstateRepository = realEstateRepository;
        this.modelMapper = modelMapper;
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

    public List<ClientResponseDto> getAllClients() {

        Iterable<Client> clients = clientRepository.findAll();
        List<ClientResponseDto> clientResponseDtos = new ArrayList<>();

        for(Client client : clients) {
            ClientResponseDto clientResponseDto = modelMapper.map(client, ClientResponseDto.class);
            clientResponseDtos.add(clientResponseDto);
        }

        return clientResponseDtos;

    }

    public Optional<Client> getClientById(int clientId) {
        return clientRepository.findById(clientId);
    }

    public void deleteClientById(int clientId) {
        clientRepository.deleteById(clientId);
    }

}
