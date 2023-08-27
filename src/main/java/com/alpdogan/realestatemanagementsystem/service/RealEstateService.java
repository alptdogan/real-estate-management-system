package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.request.UpdateRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.Client;
import com.alpdogan.realestatemanagementsystem.entity.ERealEstateType;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
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

        String realEstateNameRequest = saveRealEstateRequestDto.getRealEstateName();
        int squareMetersRequest = saveRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = saveRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = saveRealEstateRequestDto.getFloorNo();
        int clientIdRequest = saveRealEstateRequestDto.getClientId();
        String realEstateTypeRequest = saveRealEstateRequestDto.getRealEstateType();

        RealEstate realEstate = new RealEstate();
        Client client = clientRepository.findById(clientIdRequest).get();

        realEstate.setRealEstateName(realEstateNameRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);
        realEstate.setClient(client);
        realEstate.setERealEstateType(ERealEstateType.valueOf(realEstateTypeRequest));

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
        String realEstateNameRequest = updateRealEstateRequestDto.getRealEstateName();
        int squareMetersRequest = updateRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = updateRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = updateRealEstateRequestDto.getFloorNo();
        int clientIdRequest = updateRealEstateRequestDto.getClientId();
        String realEstateTypeRequest = updateRealEstateRequestDto.getRealEstateType();

        Optional<RealEstate> realEstateOptional = realEstateRepository.findById(realEstateIdRequest);

        RealEstate realEstate = realEstateOptional.get();

        realEstate.setRealEstateName(realEstateNameRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);
        realEstate.getClient().setClientId(clientIdRequest);
        realEstate.setERealEstateType(ERealEstateType.valueOf(realEstateTypeRequest));

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

    public List<RealEstateResponseDto> getRealEstateByRealEstateType(ERealEstateType realEstateType) {

        Iterable<RealEstate> realEstates = realEstateRepository.searchByRealEstateType(realEstateType);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

    public List<RealEstateResponseDto> getRealEstatesByItsProperties(int numberOfRooms, int floorNo, int squareMeters, ERealEstateType eRealEstateType) {

        List<RealEstate> realEstates = realEstateRepository.findRealEstatesByItsProperties(numberOfRooms, floorNo, squareMeters, eRealEstateType);
        List<RealEstateResponseDto> typeRealEstateResponseDtos = new ArrayList<>();

        for(RealEstate realEstate : realEstates) {
            RealEstateResponseDto typeRealEstateResponseDto = modelMapper.map(realEstate, RealEstateResponseDto.class);
            typeRealEstateResponseDtos.add(typeRealEstateResponseDto);
        }

        return typeRealEstateResponseDtos;

    }

}
