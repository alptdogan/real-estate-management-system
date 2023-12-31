package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveClientRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.ClientResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
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
