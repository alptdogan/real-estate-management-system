package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.request.UpdateRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.*;
import com.alpdogan.realestatemanagementsystem.repository.ClientRepository;
import com.alpdogan.realestatemanagementsystem.repository.RealEstateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RealEstateService {

    private RealEstateRepository realEstateRepository;
    private ModelMapper modelMapper;
    private ClientRepository clientRepository;

    public RealEstateService(RealEstateRepository realEstateRepository, ModelMapper modelMapper, ClientRepository clientRepository) {
        this.realEstateRepository = realEstateRepository;
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }

    public RealEstate saveRealEstate(SaveRealEstateRequestDto saveRealEstateRequestDto){

        String advertTitleRequest = saveRealEstateRequestDto.getAdvertTitle();
        String realEstateAddressRequest = saveRealEstateRequestDto.getRealEstateAddress();
        int squareMetersRequest = saveRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = saveRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = saveRealEstateRequestDto.getFloorNo();
        int priceRequest = saveRealEstateRequestDto.getPrice();
        int clientIdRequest = saveRealEstateRequestDto.getClientId();
        String realEstateTypeRequest = saveRealEstateRequestDto.getRealEstateType();
        String saleOrRentRequest = saveRealEstateRequestDto.getSaleOrRent();
        String townRequest = saveRealEstateRequestDto.getTown();

        RealEstate realEstate = new RealEstate();
        Client client = clientRepository.findById(clientIdRequest).get();

        realEstate.setAdvertTitle(advertTitleRequest);
        realEstate.setRealEstateAddress(realEstateAddressRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);
        realEstate.setPrice(priceRequest);
        realEstate.setClient(client);
        realEstate.setERealEstateType(ERealEstateType.valueOf(realEstateTypeRequest));
        realEstate.setESaleOrRent(ESaleOrRent.valueOf(saleOrRentRequest));
        realEstate.setETown(ETown.valueOf(townRequest));

        return realEstateRepository.save(realEstate);
    }

    public Optional<RealEstate> getRealEstateById(int realEstateId) {
        return realEstateRepository.findById(realEstateId);
    }

    public List<RealEstateResponseDto> getAllRealEstates() {

        Iterable<RealEstate> realEstates = realEstateRepository.findAll();
        List<RealEstateResponseDto> realEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto realEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            realEstateResponseDtos.add(realEstateResponseDto);
        }

        return realEstateResponseDtos;

    }

    public RealEstate updateRealEstateById(UpdateRealEstateRequestDto updateRealEstateRequestDto) {

        int realEstateIdRequest = updateRealEstateRequestDto.getRealEstateId();
        String advertTitleRequest = updateRealEstateRequestDto.getAdvertTitle();
        String realEstateAddressRequest = updateRealEstateRequestDto.getRealEstateAddress();
        int squareMetersRequest = updateRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = updateRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = updateRealEstateRequestDto.getFloorNo();
        int priceRequest = updateRealEstateRequestDto.getPrice();
        int clientIdRequest = updateRealEstateRequestDto.getClientId();
        String realEstateTypeRequest = updateRealEstateRequestDto.getRealEstateType();
        String saleOrRentRequest = updateRealEstateRequestDto.getSaleOrRent();
        String townRequest = updateRealEstateRequestDto.getTown();

        Optional<RealEstate> realEstateOptional = realEstateRepository.findById(realEstateIdRequest);

        RealEstate realEstate = realEstateOptional.get();

        realEstate.setAdvertTitle(advertTitleRequest);
        realEstate.setRealEstateAddress(realEstateAddressRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);
        realEstate.setPrice(priceRequest);
        realEstate.getClient().setClientId(clientIdRequest);
        realEstate.setERealEstateType(ERealEstateType.valueOf(realEstateTypeRequest));
        realEstate.setESaleOrRent(ESaleOrRent.valueOf(saleOrRentRequest));
        realEstate.setETown(ETown.valueOf(townRequest));

        return realEstateRepository.save(realEstate);

    }

    public void deleteRealEstateById(int realEstateId) {
        realEstateRepository.deleteById(realEstateId);
    }

    public List<RealEstate> getRealEstateByNumberOfRooms(int numberOfRooms) {
        return realEstateRepository.searchByNumberOfRooms(numberOfRooms);
    }

    public List<RealEstate> getRealEstateBySquareMeters(int squareMeters) {
        return realEstateRepository.searchBySquareMeters(squareMeters);
    }

    public List<RealEstate> getRealEstateByFloorNo(int floorNo) {
        return realEstateRepository.searchByFloorNo(floorNo);
    }

    public List<RealEstate> getRealEstateByPrice(int price) {
        return realEstateRepository.searchByPrice(price);
    }

    public List<RealEstateResponseDto> getRealEstateByRealEstateType(ERealEstateType realEstateType) {

        Iterable<RealEstate> realEstates = realEstateRepository.searchByRealEstateType(realEstateType);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

    public List<RealEstateResponseDto> getRealEstateBySaleOrRent(ESaleOrRent saleOrRent) {

        Iterable<RealEstate> realEstates = realEstateRepository.searchBySaleOrRent(saleOrRent);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

    public List<RealEstateResponseDto> getRealEstateByTown(ETown town) {

        Iterable<RealEstate> realEstates = realEstateRepository.searchByTown(town);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

    public List<RealEstateResponseDto> getRealEstatesByItsProperties(int numberOfRooms, int floorNo, int squareMeters,
                                                                     ERealEstateType eRealEstateType, ESaleOrRent saleOrRent, ETown town) {

        List<RealEstate> realEstates = realEstateRepository
                .findRealEstatesByItsProperties(numberOfRooms, floorNo, squareMeters, eRealEstateType, saleOrRent, town);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

}
