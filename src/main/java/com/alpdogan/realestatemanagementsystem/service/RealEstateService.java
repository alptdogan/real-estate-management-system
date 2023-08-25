package com.alpdogan.realestatemanagementsystem.service;

import com.alpdogan.realestatemanagementsystem.dto.request.SaveRealEstateRequestDto;
import com.alpdogan.realestatemanagementsystem.dto.response.RealEstateResponseDto;
import com.alpdogan.realestatemanagementsystem.entity.RealEstate;
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

    public RealEstateService(RealEstateRepository realEstateRepository, ModelMapper modelMapper) {
        this.realEstateRepository = realEstateRepository;
        this.modelMapper = modelMapper;
    }

    public RealEstate saveRealEstate(SaveRealEstateRequestDto saveRealEstateRequestDto){

        String realEstateNameRequest = saveRealEstateRequestDto.getRealEstateName();
        int squareMetersRequest = saveRealEstateRequestDto.getSquareMeters();
        int numberOfRoomsRequest = saveRealEstateRequestDto.getNumberOfRooms();
        int floorNoRequest = saveRealEstateRequestDto.getFloorNo();

        RealEstate realEstate = new RealEstate();

        realEstate.setRealEstateName(realEstateNameRequest);
        realEstate.setSquareMeters(squareMetersRequest);
        realEstate.setNumberOfRooms(numberOfRoomsRequest);
        realEstate.setFloorNo(floorNoRequest);

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

    public void deleteRealEstateById(int realEstateId) {
        realEstateRepository.deleteById(realEstateId);
    }

}
